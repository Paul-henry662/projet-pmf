package pmf.view;

import javax.swing.JOptionPane;

import pmf.controller.PMFController;

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
	public void updateValues(float internalTemp, float externalTemp, float ambiantHumidity) {
		this.getFrame().getLblInternalTempValueCelsius().setText(internalTemp + " °C");
		this.getFrame().getLabelInternalTempValueKelvin().setText(internalTemp + 273.15f + " K");
		
		this.getFrame().getLabelExternalTempValueCelsius().setText(externalTemp + " °C");
		this.getFrame().getLabelExternalTempValueKelvin().setText(externalTemp + 273.15f + " K");
		
		this.getFrame().getLabelHumdityValue().setText(ambiantHumidity + " %");
	}
	
	public void setActionListener(PMFController actionListener) {
		this.getFrame().getBtnOrderTemp().addActionListener(actionListener);
	}
	
	public void displayInfo(String message) {
		JOptionPane.showMessageDialog(this.getFrame(), message);
	}
	
	public void displayAlert(String message) {
		JOptionPane.showMessageDialog(this.getFrame(), message);
	}

}