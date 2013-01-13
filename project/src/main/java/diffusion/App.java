package diffusion;

import utils.Clock;
import diffusion.channel.proxy.Channel;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.display.ihm.IIhm;
import diffusion.display.ihm.Ihm;
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
		
		
		IDisplay display1 = new Display("Display_1");
		IDisplay display2 = new Display("Display_2");
		IDisplay display3 = new Display("Display_3");
		
		IIhm ihm = new Ihm();
		ihm.addDisplay(display1.getPresentation());
		ihm.addDisplay(display2.getPresentation());
		ihm.addDisplay(display3.getPresentation());
		
		Channel channel1 = new Channel("Channel_1", display1);
		Channel channel2 = new Channel("Channel_2", display2);
		Channel channel3 = new Channel("Channel_3", display3);
		
		ISensor sensor = new Sensor();
		sensor.attach(channel1);
		sensor.attach(channel2);
		sensor.attach(channel3);
		
		Clock h = new Clock();
		h.periodicallyActivate(sensor, 1000);
		
	}
}
