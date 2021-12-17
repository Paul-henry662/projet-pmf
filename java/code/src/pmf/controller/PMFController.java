package pmf.controller;


import pmf.model.*;
import pmf.view.*;
import java.awt.event.*;
public class PMFController implements ActionListener{

	private static String PORT_NAME = "COM4";

	private PMFModel model;
	private PMFSerial serialConn;
	private PMFView view;
	
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public PMFController(PMFView view, PMFModel model) {
		this.setView(view);
		this.getView().setActionListener(this);
		this.setModel(model);
		this.setSerialConn(new PMFSerial(PORT_NAME));
	}


	public PMFModel getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(PMFModel model) {
		this.model = model;
	}

	public PMFSerial getSerialConn() {
		return this.serialConn;
	}

	/**
	 * 
	 * @param serialConn
	 */
	public void setSerialConn(PMFSerial serialConn) {
		this.serialConn = serialConn;
	}

	public void start() {
		this.getSerialConn().getPort().addDataListener(model);
		this.getModel().addObserver(this);
		this.getSerialConn().connect();
		
		this.getView().getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	close();
		    }
		});
		this.getView().start();
		
		System.out.println("=== Ouverture de la connexion sur le port " + PORT_NAME + " ===");
	}

	public void close() {
		this.getSerialConn().getPort().removeDataListener();
		this.getModel().removeObserver(this);
		this.getSerialConn().disconnect();
		
		System.out.println("=== Fermeture de la connexion sur le port " + PORT_NAME + " ===");
	}

	public void update() {
		System.out.println(this.getModel().getFridge());
		
		float internalTemp = this.getModel().getFridge().getInternalTemp();
		float externalTemp = this.getModel().getFridge().getExternalTemp();
		float ambiantHumidity = this.getModel().getFridge().getAmbiantHumidity();
		
		this.getView().updateValues(internalTemp, externalTemp, ambiantHumidity);
		
		if(this.getModel().getFridge().isDewPossible()) {
			this.getView().displayAlert("Risque de condensation");
		}
		
		if(this.getModel().getFridge().isTempCritical()) {
			this.getView().displayAlert("La température est critique");
		}
	}

	public PMFView getView() {
		return this.view;
	}

	/**
	 * 
	 * @param view
	 */
	public void setView(PMFView view) {
		this.view = view;
	}

	/**
	 * 
	 * @param orderTemp
	 */
	public void changeOrderTemp(float orderTemp) {
		this.getSerialConn().write(""+orderTemp);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getView().getFrame().getBtnOrderTemp()) {
			float newOrderTemp = this.getView().getFrame().getSliderOrderTemp().getValue();
			
			this.getView().getFrame().getFieldOrderTemp().setText(newOrderTemp+"");
			
			this.changeOrderTemp(newOrderTemp);
			this.getView().displayInfo("Température de consigne modifiée");
		}
	}

}