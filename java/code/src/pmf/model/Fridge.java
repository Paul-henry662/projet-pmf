package pmf.model;

public class Fridge {

	private float internalTemp;
	private float externalTemp;
	private float ambiantHumidity;

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

	public String toString() {
		return "Temp. interne: " + this.getInternalTemp()
				+"\nTemp. externe: " + this.getExternalTemp()
				+"\nHumidité ambiante: " + this.getAmbiantHumidity();
	}

}