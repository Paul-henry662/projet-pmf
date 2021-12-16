package pmf.model;

import com.fazecast.jSerialComm.*;

public class PMFSerial {

	private SerialPort port;
	private boolean connected;

	/**
	 * 
	 * @param portName
	 */
	public PMFSerial(String portName) {
		this.setPort(SerialPort.getCommPort(portName));
		this.setConnected(false);
	}

	public void connect() {
		this.getPort().openPort();
		this.setConnected(true);
	}

	public void disconnect() {
		this.getPort().closePort();
		this.setConnected(false);
	}
	
	/**
	 * 
	 * @param temp
	 */
	public void write(String data) {
		this.getPort().writeBytes(data.getBytes(), data.length());
	}

	public SerialPort getPort() {
		return this.port;
	}

	/**
	 * 
	 * @param port
	 */
	public void setPort(SerialPort port) {
		this.port = port;
	}

	public boolean isConnected() {
		return this.connected;
	}

	/**
	 * 
	 * @param connected
	 */
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
}