package pmf.main;

import pmf.controller.*;
import pmf.model.*;
import pmf.view.*;

public class PMFMain {

	/**
	 * 
	 * @param args
	 */
	 
	public static void main(String[] args) {
		PMFView view = new PMFView();
		PMFModel model = new PMFModel();
		PMFController controller = new PMFController(view, model);
		
		controller.start();
		
		while(true) {
			controller.changeOrderTemp(67f);
		}
	}

}