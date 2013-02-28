package diffusion.sensor.strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Clock;
import diffusion.App;
import diffusion.channel.proxy.Channel;
import diffusion.channel.proxy.IChannel;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;

public class AtomicDiffusionIntegrationTest {

	private ISensor sensor;
	private IChannel channel1;
	private IDisplay display1;
	private IChannel channel2;
	private IDisplay display2;
	
	private Clock timer;
	
	
	@Before
	public void setUp() throws Exception {
		sensor = new Sensor();
		
		display1 = new Display("Display_1");
		channel1 = new Channel("Channel_1", display1);
		
		display2 = new Display("Display_2");
		channel2 = new Channel("Channel_2", display2);
		timer = new Clock();
		
		
		sensor.attach(channel1);
		sensor.attach(channel2);
		
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		
		System.out.println("-------------------->>>>");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("<<<<--------------------");
	}
	
	/**
	 * Test the Atomic diffusion between sensor and display
	 */
	@Test
	public void testValuesConsistencyBetweenSensorAndDisplay() {
		sensor.tick();
		timer.periodicallyActivate(sensor, 2d);
		
		int sensorValue = sensor.getValue();
		long sensorVersion = sensor.getVersion();
				
		int display1Value = display1.getValue();
		long display1Version = display1.getVersion();
		
		display2.getValue();
		
		assertEquals("Values consistency : sensor - display", sensorValue, display1Value);
		assertEquals("Version consistency : sensor - display", sensorVersion, display1Version);
	}

	/**
	 * Test the Atomic diffusion between two displays
	 */
	@Test
	public void testValuesConsistencyBetweenTwoDisplays() {
		sensor.tick();
		timer.periodicallyActivate(sensor, 2d);
		
		int display1Value = display1.getValue();
		long display1Version = display1.getVersion();
		
		int display2Value = display2.getValue();
		long display2Version = display2.getVersion();
		
		assertEquals("Values consistency : display1 - display2", display1Value, display2Value);
		assertEquals("Version consistency : display1 - display2", display1Version, display2Version);
	}
	
	/**
	 * Test the Atomic diffusion between two displays
	 */
	@Test
	public void testValuesConsistencySensorDontChangedItsValueDuringTheDisplaysGetValue() {
		sensor.tick();
		timer.periodicallyActivate(sensor, 2d);
		
		// Value before display getValue
		int sensorStartValue = sensor.getRealSensorValue();
		long sensorStartVersion = sensor.getRealSensorVersion();
		
		display1.getValue();
		display2.getValue();
		
		// Value just after display getValue
		int sensorEndValue = sensor.getRealSensorValue();
		long sensorEndVersion = sensor.getRealSensorVersion();
		
		assertEquals("Values consistency : sensor state", sensorStartValue, sensorEndValue);
		assertEquals("Version consistency : sensor state", sensorStartVersion, sensorEndVersion);
	}

}
