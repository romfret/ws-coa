package integration;

import static org.junit.Assert.*;

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

public class ValueTests {
	
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
	}

	/**
	 * Test the Atomic diffusion between sensor and two displays
	 */
	@Test
	public void testAtomic() {
		System.out.println("-------------------->>>>");
		
		sensor.setDiffusion(App.ATOMIC_DIFFUSION);
		sensor.tick();
		timer.periodicallyActivate(sensor, 2d);
		
		int valueSensor = sensor.getValue();
		
		int valueDisplay1 = display1.getValue();
		int valueDisplay2 = display2.getValue();
		
//		System.out.println("s: " + valueSensor + "     d1: " + valueDisplay1 + "     d2: " + valueDisplay2);
		assertEquals("Values consistency : sensor - display", valueSensor, valueDisplay1);
		assertEquals("Values consistency : display1 - display2", valueDisplay1, valueDisplay2);
		
		System.out.println("<<<<--------------------");
	}
	
	/**
	 * Test the Sequential diffusion between sensor and two displays
	 */
	@Test
	public void testSequential() {
		System.out.println("-------------------->>>>");
		
		sensor.setDiffusion(App.SEQUENTIAL_DIFFUSION);
		sensor.tick();
		timer.periodicallyActivate(sensor, 1000d);
		
		int valueSensor = sensor.getValue();
		
		// Wait that displays get their own value
		boolean done = false;
		while (!done) {
			if (display1.getVersion() > 0 && display2.getVersion() > 0)
				done = true;
		}
		
		int valueDisplay1 = display1.getValue();
		int valueDisplay2 = display2.getValue();
		
//		System.out.println("s: " + valueSensor + "     d1: " + valueDisplay1 + "     d2: " + valueDisplay2);
		assertEquals("Values consistency : sensor - display", valueSensor, valueDisplay1);
		assertEquals("Values consistency : display1 - display2", valueDisplay1, valueDisplay2);
		
		System.out.println("<<<<--------------------");
	}

}
