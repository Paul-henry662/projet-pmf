package pmf.view;

public class PMFView {

	private PMFFrame frame;

	public PMFView() {
		this.frame = new PMFFrame();
	}
	
	public void start() {
		this.frame.setVisible(true);
	}

	public PMFFrame getFrame() {
		return frame;
	}

	public void setFrame(PMFFrame frame) {
		this.frame = frame;
	}

	/**
	 * 
	 * @param internalTemp
	 * @param externalTemp
	 * @param ambiantHumidity
	 */
	public void displayValues(float internalTemp, float externalTemp, float ambiantHumidity) {

	}

}