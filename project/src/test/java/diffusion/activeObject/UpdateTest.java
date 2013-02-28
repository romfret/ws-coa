package diffusion.activeObject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;

public class UpdateTest {
	
	private IUpdate update;

	@Before
	public void setUp() throws Exception {
		update = new Update();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test the getter/setter of the observer
	 */
	@Test
	public void testGetSetObserver() {
		IDisplay display = new Display("A");
		update.setObserver(display);
		assertEquals("testGetSetObserver", display, update.getObserver());
	}

	/**
	 * test the getter/setter of the subject
	 */
	@Test
	public void testGetSetSubject() {
		ISensor subject = new Sensor();
		update.setSubject(subject);
		assertEquals("testGetSetSubject", subject, update.getSubject());
	}

	/**
	 * test the getter/setter of the name
	 */
	@Test
	public void testGetSetName() {
		update.setName("name");
		assertEquals("testGetSetName", "name", update.getName());
	}
}
