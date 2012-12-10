package diffusion;

import diffusion.channel.proxy.Channel;
import diffusion.display.Display;
import diffusion.display.DisplayImpl;
import diffusion.sensor.Sensor;
import diffusion.sensor.SensorImpl;
import diffusion.sensor.strategy.AtomicDiffusionImpl;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	public static void main(String[] args) {
		Channel channel = new Channel();
		Sensor sensor = new SensorImpl(new AtomicDiffusionImpl(channel));
		Display display = new DisplayImpl();
		
		
		sensor.attach(display);
	}
}
