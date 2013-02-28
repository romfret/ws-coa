package diffusion.sensor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import main.App;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diffusion.sensor.strategy.AtomicDiffusion;
import diffusion.sensor.strategy.PeriodDiffusion;
import diffusion.sensor.strategy.SequentialDiffusion;

public class SensorTest {

	private ISensor sensor;
	
	@Before
	public void setUp() throws Exception {
		sensor = new Sensor();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Sensor change value test
	 */
	@Test
	public void testTick() {
		sensor.tick();
		long ver1 = sensor.getRealSensorVersion();
		sensor.tick();
		long ver2 = sensor.getRealSensorVersion();
		
		assertEquals("testTick", ver2, ver1 + 1);
	}
	
	@Test
	public void testGetRealSensorVersion() {
		sensor.tick();
		long ver1 = sensor.getRealSensorVersion();
		sensor.tick();
		long ver2 = sensor.getRealSensorVersion();
		
		assertEquals("testGetRealSensorVersion", ver2, ver1 + 1);
	}
	
	@Test
	public void testSetDiffusionWithAtomic() {
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		assertTrue("testSetDiffusionWithAtomic", sensor.getDiffusion() instanceof AtomicDiffusion);
	}
	
	@Test
	public void testSetDiffusionWithSequential() {
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		assertTrue("testSetDiffusionWithSequential", sensor.getDiffusion() instanceof SequentialDiffusion);
	}
	
	@Test
	public void testSetDiffusionWithPeriod() {
		sensor.setDiffusion(App.PERIOD_DIFFUSION);
		assertTrue("testSetDiffusionWithPeriod", sensor.getDiffusion() instanceof PeriodDiffusion);
	}
	
	@Test
	public void testGetVersionWithAtomicDiffusion() {
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		
		sensor.tick();
		long ver1 = sensor.getVersion();
		sensor.tick();
		long ver2 = sensor.getVersion();
		
		assertEquals("testGetVersionWithAtomicDiffusion", ver2, ver1 + 1);
	}
	
	@Test
	public void testGetVersionWithSequentialDiffusion() {
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		
		sensor.tick();
		long ver1 = sensor.getVersion();
		sensor.tick();
		long ver2 = sensor.getVersion();
		
		assertEquals("testGetVersionWithSequentialDiffusion", ver2, ver1 + 1);
	}
	
	@Test
	public void testGetVersionWithPeriodDiffusion() {
		sensor.setDiffusion(App.PERIOD_DIFFUSION);
		
		sensor.tick();
		long ver1 = sensor.getVersion();
		sensor.tick();
		long ver2 = sensor.getVersion();
		
		assertEquals("testGetVersionWithPeriodDiffusion", ver2, ver1 + 1);
	}
	
	/**
	 * Test getValue and getRealValue in atomic diffusion case
	 */
	@Test
	public void testGetValueWithAtomicDiffusion() {
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getRealSensorValue();
		int val2 = sensor.getValue();
		
		assertEquals("testGetValueWithAtomicDiffusion", val1, val2);
	}
	
	/**
	 * Test getValue and getRealValue in sequential diffusion case
	 */
	@Test
	public void testGetValueWithSequentialDiffusion() {
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getRealSensorValue();
		int val2 = sensor.getValue();
		
		assertEquals("testGetValueWithSequentialDiffusion", val1, val2);
	}
	
	/**
	 * Test getValue and getRealValue in period diffusion case
	 */
	@Test
	public void testGetValueWithPeriodDiffusion() {
		sensor.setDiffusion(App.PERIOD_DIFFUSION);
		
		sensor.tick();
		int val1 = sensor.getRealSensorValue();
		int val2 = sensor.getValue();
		
		assertEquals("testGetValueWithPeriodDiffusion", val1, val2);
	}
}
