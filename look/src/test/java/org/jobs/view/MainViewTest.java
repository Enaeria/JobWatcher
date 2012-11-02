package org.jobs.view;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.jobs.MainController;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainViewTest {

	@Test
	public void testViewNeedsController() {
		
		try {
			new MainView(null);
			fail("Controller cannot be null!");
		} catch (IllegalArgumentException e) {
			
		}		
		
	}
	
	@Test
	public void testShow() {
		final MainController controller = new MainController(); 
		final MainView mainView = new MainView(controller);
		final JFrame frame = mock(JFrame.class);
		mainView.setMainFrame(frame);		
		mainView.show();
		
		verify(frame).setVisible(true);
		verifyNoMoreInteractions(frame);
	}

}
