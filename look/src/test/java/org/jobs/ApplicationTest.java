package org.jobs;

import org.jobs.view.MainView;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ApplicationTest {

	@Test
	public void test() {
		final Application app = new Application();
		final MainController mainController = mock(MainController.class);	
		
		app.startApplication(mainController);
		
		verify(mainController).setView(isA(MainView.class));
		verify(mainController).takeControl();
		verifyNoMoreInteractions(mainController);		
	}

}
