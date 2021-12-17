package pmf.model;

import com.fazecast.jSerialComm.*;
import java.util.*;
import pmf.controller.*;

public class PMFModel implements SerialPortMessageListener {

	private Fridge fridge;
	private List<PMFController> observers;
	private byte DELIMITER = (byte) 0x3B;

	public PMFModel() {
		this.fridge = new Fridge(0f, 0f, 0f);
		this.observers = new ArrayList<PMFController>();
	}

	public Fridge getFridge() {
		return this.fridge;
	}

	/**
	 * 
	 * @param fridge
	 */
	public void setFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	@Override
	public int getListeningEvents() {
		return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
	}

	/**
	 * 
	 * @param event
	 */
	@Override
	public void serialEvent(SerialPortEvent event) {
		byte[] rawData = event.getReceivedData();
		String message = new String(rawData);
		
		String[] params = message.replaceFirst(";", "").split(":");
		
		float internalTemp = Float.valueOf(params[0]);
		float externalTemp = Float.valueOf(params[1]);
		float ambiantHumidity = Float.valueOf(params[2]);
		boolean dewPossible = Boolean.valueOf(params[3]);
		boolean tempCritical = Boolean.valueOf(params[4]);
		
		this.getFridge().setInternalTemp(internalTemp);
		this.getFridge().setExternalTemp(externalTemp);
		this.getFridge().setAmbiantHumidity(ambiantHumidity);
		this.getFridge().setDewPossible(dewPossible);
		this.getFridge().setTempCritical(tempCritical);
		
		this.notifyObservers();
	}

	@Override
	public boolean delimiterIndicatesEndOfMessage() {
		return true;
	}

	@Override
	public byte[] getMessageDelimiter() {
		return new byte[] { DELIMITER };
	}

	/**
	 * 
	 * @param observer
	 */
	public void addObserver(PMFController observer) {
		this.observers.add(observer);
	}

	public void notifyObservers() {
		for (PMFController observer : this.observers)
			observer.update();
	}

	/**
	 * 
	 * @param observer
	 */
	public void removeObserver(PMFController observer) {
		this.observers.remove(observer);
	}

}