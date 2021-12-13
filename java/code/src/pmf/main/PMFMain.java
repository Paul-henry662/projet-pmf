package pmf.main;

import pmf.controller.*;
import pmf.model.*;

public class PMFMain {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PMFModel model = new PMFModel();
		PMFController controller = new PMFController(model);
		
		controller.start();
		
		controller.getSerialConn().write(15.5f);
	}

}