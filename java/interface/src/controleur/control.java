package controleur;

import vue.frmforme;

public class control {

	
	//propriete
	private frmforme Frmforme;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new control();
	}
	/**
	 * constructeur
	 */
	public control() {
		Frmforme = new frmforme(this);
		Frmforme.setVisible(true);
	}
}
