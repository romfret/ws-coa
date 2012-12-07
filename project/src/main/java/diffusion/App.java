package diffusion;

import diffusion.channel.proxy.Channel;
import diffusion.display.Display;
import diffusion.display.DisplayImpl;
import diffusion.sensor.Sensor;
import diffusion.sensor.SensorImpl;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	public static void main(String[] args) {
		Sensor sensor = new SensorImpl();
		Display display = new DisplayImpl();
		Channel channel = new Channel(sensor);
		
		
		sensor.attach(display);
	}
}
