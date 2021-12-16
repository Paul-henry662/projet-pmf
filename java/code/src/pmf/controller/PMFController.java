package pmf.controller;


import pmf.model.*;
import pmf.view.*;

public class PMFController {

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

}