package diffusion.display.gui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisplayGUITest {
	
	private DisplayGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new DisplayGUI("A");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test of the getter/setter for the value
	 */
	@Test
	public void testGetSetValue() {
		int nb = 12;
		gui.setValue(nb);
		assertEquals("testGetSetValue", nb, gui.getValue());
	}

	/**
	 * test of the getter/setter for the version
	 */
	@Test
	public void testGetSetVersion() {
		long version = 1234;
		gui.setVersion(version);
		assertEquals("testGetSetVersion", version, gui.getVersion());
	}
}
