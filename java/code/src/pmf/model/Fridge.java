package pmf.model;

import java.util.Objects;

public class Fridge {

	private float internalTemp;
	private float externalTemp;
	private float ambiantHumidity;
	private boolean dewPossible;
	private boolean tempCritical;
	private boolean running;

	public Fridge() {

	}
	
	/**
	 * 
	 * @param internalTemp
	 * @param externalTemp
	 * @param ambiantHumidity
	 */
	public Fridge(float internalTemp, float externalTemp, float ambiantHumidity) {
		this.internalTemp = internalTemp;
		this.externalTemp = externalTemp;
		this.ambiantHumidity = ambiantHumidity;
	}

	public float getInternalTemp() {
		return this.internalTemp;
	}

	/**
	 * 
	 * @param internalTemp
	 */
	public void setInternalTemp(float internalTemp) {
		this.internalTemp = internalTemp;
	}

	public float getExternalTemp() {
		return this.externalTemp;
	}

	/**
	 * 
	 * @param externalTemp
	 */
	public void setExternalTemp(float externalTemp) {
		this.externalTemp = externalTemp;
	}

	public float getAmbiantHumidity() {
		return this.ambiantHumidity;
	}

	/**
	 * 
	 * @param ambiantHumidity
	 */
	public void setAmbiantHumidity(float ambiantHumidity) {
		this.ambiantHumidity = ambiantHumidity;
	}
	
	public boolean isDewPossible() {
		return dewPossible;
	}

	public void setDewPossible(boolean dewPossible) {
		this.dewPossible = dewPossible;
	}

	public boolean isTempCritical() {
		return tempCritical;
	}

	public void setTempCritical(boolean tempCritical) {
		this.tempCritical = tempCritical;
	}
	
	public boolean isRunning() {
		return this.running;
	}

	/**
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}


	public String toString() {
		return "Temp. interne: " + this.getInternalTemp()
				+"\nTemp. externe: " + this.getExternalTemp()
				+"\nHumidité ambiante: " + this.getAmbiantHumidity()
				+"\nCondensation possible: " + this.isDewPossible();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ambiantHumidity, externalTemp, internalTemp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fridge other = (Fridge) obj;
		return Float.floatToIntBits(ambiantHumidity) == Float.floatToIntBits(other.ambiantHumidity)
				&& Float.floatToIntBits(externalTemp) == Float.floatToIntBits(other.externalTemp)
				&& Float.floatToIntBits(internalTemp) == Float.floatToIntBits(other.internalTemp);
	}
}