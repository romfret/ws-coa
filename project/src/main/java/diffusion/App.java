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
	public static void main(String[] args) {
//		IDiffusion atomicDiffusion = new AtomicDiffusion();
		
//		ISensor sensor = new Sensor(atomicDiffusion);
		ISensor sensor = new Sensor();
		IDisplay display1 = new Display("Display_1");
		IDisplay display2 = new Display("Display_2");
		
		Channel channel1 = new Channel("Channel_1", display1);
		Channel channel2 = new Channel("Channel_2", display2);
		
//		((AtomicDiffusion)atomicDiffusion).setSensor(sensor);
		sensor.attach(channel1);
		sensor.attach(channel2);
		
		Horloge h = new Horloge();
		h.periodicallyActivate(sensor, 1000);
		
	}
}
