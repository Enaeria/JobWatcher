package org.jobs;

import org.jobs.view.MainView;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		final MainController mainController = new MainController();
		Application app = new Application();
		app.startApplication(mainController);
	}

	public void startApplication(final MainController controller) {
		final MainView mainView = new MainView(controller);
		controller.setView(mainView);		
		controller.takeControl();
	}

}
