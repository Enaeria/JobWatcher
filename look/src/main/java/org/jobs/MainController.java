package org.jobs;

import javax.swing.SwingUtilities;

import org.jobs.model.DataController;
import org.jobs.model.Model;
import org.jobs.view.MainView;

public class MainController {
	
	private MainView view;
	private final DataController dataController;
	private Model model;
	
	public MainController() {
		dataController = new DataController();
	}
	
	protected MainController(final DataController datacontroller) {
		dataController = datacontroller;
	}

	public void setView(final MainView mainView) {
		view = mainView;
	}

	public void takeControl() {
		view.show();
		setModel(dataController.fetchModel());
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				view.showModel(model);				
			}
		});
		
	}

	public MainView getView() {
		return view;
	}

	public DataController getDataController() {
		return dataController;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
