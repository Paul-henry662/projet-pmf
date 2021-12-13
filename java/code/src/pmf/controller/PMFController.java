package pmf.controller;

import pmf.model.*;

public class PMFController {

	private static String PORT_NAME = "COM4";

	private PMFModel model;
	private PMFSerial serialConn;

	/**
	 * 
	 * @param model
	 */
	public PMFController(PMFModel model) {
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
		
		System.out.println("=== Ouverture de la connexion sur le port " + PORT_NAME + " ===");
	}

	public void close() {
		this.getSerialConn().getPort().removeDataListener();
		this.getModel().removeObserver(this);
		this.getSerialConn().disconnect();
		
		System.out.println("=== Fermeture de la connexion sur le port " + PORT_NAME + " ===");
	}

	public void update() {
		System.out.println(this.model.getFridge() + "\n");
	}

}