package org.jobs.view;

import javax.swing.JFrame;

import org.jobs.MainController;
import org.jobs.model.Model;

public class MainView {

	private JFrame mainFrame;
	
	public MainView(final MainController controller) {
		if (controller == null) {
			throw new IllegalArgumentException("The controller mustnt be null");
		}
		
		setMainFrame(new JFrame());
	}

	public void show() {		
		mainFrame.setVisible(true);
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	protected void setMainFrame(JFrame jFrame) {
		mainFrame = jFrame;
		
	}

	public void showModel(final Model model) {
		
	}


}
