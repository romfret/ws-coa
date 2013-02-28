package gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gui.command.CommandAddDisplay;
import gui.command.CommandDiffusion;
import gui.command.CommandRemoveDisplay;
import gui.command.ICommand;
import gui.command.ICommandDiffusion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diffusion.sensor.Sensor;

public class GlobalGUITest {

	private IGlobalGUI gui;
	@Before
	public void setUp() throws Exception {
		gui = new GlobalGUI();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * test if the getDisplays method return a list of displays 
	 */
	@Test
	public void testGetDisplays() {
		assertEquals("testGetDisplays", 0, gui.getDisplays().size());
	}

	/**
	 * test if the display is added into the list
	 */
	@Test
	public void testAddDisplay() {
		DisplayGUI display = new DisplayGUI("A");
		gui.addDisplay(display);
		assertTrue("testAddDisplay", gui.getDisplays().contains(display));
	}

	/**
	 * test if the display is removed from the list
	 */
	@Test
	public void testRemoveDisplay() {
		DisplayGUI display = new DisplayGUI("A");
		gui.addDisplay(display);
		assertTrue("testAddDisplay", gui.getDisplays().contains(display));
		gui.removeDisplay(display);
		assertFalse("testAddDisplay", gui.getDisplays().contains(display));
	}

	/**
	 * test of the getter/setter of the Diffusion command
	 */
	@Test
	public void testGetSetCommandDiffusion() {
		ICommandDiffusion diffusionCmd = new CommandDiffusion(new Sensor());
		gui.setCommandDiffusion(diffusionCmd);
		assertEquals("testGetSetCommandDiffusion", diffusionCmd, gui.getCommandDiffusion());
	}

	/**
	 * test of the getter/setter of the Add Display command
	 */
	@Test
	public void testGetSetCommandAddDisplay() {
		ICommand addCmd = new CommandAddDisplay();
		gui.setCommandAddDisplay(addCmd);
		assertEquals("testGetSetCommandAddDisplay", addCmd, gui.getCommandAddDisplay());
	}

	/**
	 * test of the getter/setter of the Remove Display command
	 */
	@Test
	public void testGetSetCommandRemoveDisplay() {
		ICommand removeCmd = new CommandRemoveDisplay();
		gui.setCommandRemoveDisplay(removeCmd);
		assertEquals("testGetSetCommandRemoveDisplay", removeCmd, gui.getCommandRemoveDisplay());
	}

}
