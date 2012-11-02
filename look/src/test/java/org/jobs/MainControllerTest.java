package org.jobs;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.SwingUtilities;

import static org.hamcrest.core.Is.*;

import org.jobs.model.DataController;
import org.jobs.model.Model;
import org.jobs.view.MainView;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainControllerTest {

	@Test
	public void testSetView() {
		final MainController ctroller = new MainController();
		final MainView mainView = mock(MainView.class);		
		ctroller.setView(mainView);		
		final MainView view = ctroller.getView();
		
		assertThat(view, is(mainView));
	}

	@Test
	public void testTakeControl() throws AWTException {
		final DataController dataMock = mock(DataController.class);
		final MainController ctroller = new MainController(dataMock);
		final MainView mainView = mock(MainView.class);		
		ctroller.setView(mainView);		
		ctroller.takeControl();
		new Robot().waitForIdle();
		
		verify(mainView).show();
		verify(dataMock).fetchModel();
		verify(mainView).showModel(any(Model.class));
		verifyNoMoreInteractions(mainView, dataMock);
	}
	
	@Test
	public void testTakeControlUpdateView() throws AWTException {
		final MainController ctroller = new MainController();
		final testMainView mainView = new testMainView(ctroller);
		ctroller.setView(mainView);		
		ctroller.takeControl();
		new Robot().waitForIdle();
		
		assertThat(mainView.wasCalledFromEdt(), is(true));
	}
	
	
	public class testMainView extends MainView {

		private boolean calledFromEdt = false;

		public testMainView(MainController controller) {
			super(controller);
			
		}
		
		@Override
		public void showModel(Model model) {
			if(SwingUtilities.isEventDispatchThread()) {
				setCalledFromEdt(true);
			}
		}

		public void setCalledFromEdt(boolean calledFromEdt) {
			this.calledFromEdt = calledFromEdt;
		}

		public Boolean wasCalledFromEdt() {		
			return calledFromEdt;
		}
	}
	

}
