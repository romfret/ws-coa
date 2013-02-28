package diffusion.display;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diffusion.App;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.display.gui.DisplayGUI;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;

public class DisplayTest {

	private IDisplay display;
	private ISensor sensor;
	
	@Before
	public void setUp() throws Exception {
		display = new Display("A");
		sensor = new Sensor();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * test the returned name of the Display
	 */
	@Test
	public void testGetName() {
		assertEquals("testGetName","A", display.getName());
	}
	
	/**
	 * test the returned presensation
	 */
	@Test
	public void testGetPresentation(){
		assertTrue("testGetPresentation", display.getPresentation() instanceof DisplayGUI);
	}
	
	/**
	 * test if the presentation have the values of the sensor
	 */
	@Test
	public void testUpdate(){
		sensor.tick();
		int val1 = sensor.getValue();
		long ver1 = sensor.getVersion();
		
		display.update(sensor);
		
		assertEquals("testUpdate - Value", val1, display.getPresentation().getValue());
		assertEquals("testUpdate - Version", ver1, display.getPresentation().getVersion());
	}
	
	/**
	 * test if the value is correct with the atomic diffusion
	 */
	@Test
	public void testGetValueWithAtomicDiffusion() {
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getValue();
		display.update(sensor);
		int val2 = display.getValue();
		assertEquals("testGetValueWithAtomicDiffusion", val1, val2);
	}
	
	/**
	 * test if the value is correct with the periodic diffusion
	 */
	@Test
	public void testGetValueWithPeriodicDiffusion() {
		sensor.setDiffusion(App.PERIOD_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getValue();
		display.update(sensor);
		int val2 = display.getValue();
		assertEquals("testGetValueWithPeriodicDiffusion", val1, val2);
	}
	
	/**
	 * test if the value is correct with the sequential diffusion
	 */
	@Test
	public void testGetValueWithSequentialDiffusion() {
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getValue();
		display.update(sensor);
		int val2 = display.getValue();
		assertEquals("testGetValueWithSequentialDiffusion", val1, val2);
	}
	
	/**
	 * test if the version is correct with the atomic diffusion
	 */
	@Test
	public void testGetVersionWithAtomicDiffusion() {
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		
		sensor.tick();
		long val1 = sensor.getVersion();
		
		display.update(sensor);
		
		long val2 = display.getVersion();
		assertEquals("testGetVersionWithSequentialDiffusion", val1, val2);
	}
	
	/**
	 * test if the version is correct with the periodic diffusion
	 */
	@Test
	public void testGetVersionWithPeriodicDiffusion() {
		sensor.setDiffusion(App.PERIOD_DIFFUSION);
		
		sensor.tick();
		long val1 = sensor.getVersion();
		
		display.update(sensor);
		
		long val2 = display.getVersion();
		assertEquals("testGetVersionWithSequentialDiffusion", val1, val2);
	}
	
	/**
	 * test if the version is correct with the senquential diffusion
	 */
	@Test
	public void testGetVersionWithSequentialDiffusion() {
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		
		sensor.tick();
		long val1 = sensor.getVersion();
		
		display.update(sensor);
		
		long val2 = display.getVersion();
		assertEquals("testGetVersionWithSequentialDiffusion", val1, val2);
	}
	
	/**
	 * test if the createUpdate return a null object
	 */
	@Test
	public void testCreateUpdate(){
		assertNull(display.createUpdate(sensor));
	}
	
}
