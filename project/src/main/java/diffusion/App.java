package diffusion;

import utils.Horloge;
import diffusion.channel.proxy.Channel;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	
	public static final int ANACHIC_DIFFUSION = 0;
	public static final int ATOMIC_DIFFUSION = 1;
	public static final int SEQUENTIAL_DIFFUSION = 2;
	public static final int PERIOD_DIFFUSION = 3;
	
	public static void main(String[] args) {
		ISensor sensor = new Sensor();
		
		IDisplay display1 = new Display("Display_1");
		IDisplay display2 = new Display("Display_2");
		IDisplay display3 = new Display("Display_3");
		
		Channel channel1 = new Channel("Channel_1", display1);
		Channel channel2 = new Channel("Channel_2", display2);
		Channel channel3 = new Channel("Channel_3", display3);
		
		sensor.attach(channel1);
		sensor.attach(channel2);
		sensor.attach(channel3);
		
		Horloge h = new Horloge();
		h.periodicallyActivate(sensor, 1000);
		
	}
}
