package diffusion;

import diffusion.channel.proxy.Channel;
import diffusion.display.Display;
import diffusion.display.DisplayImpl;
import diffusion.sensor.Sensor;
import diffusion.sensor.SensorImpl;
import diffusion.sensor.strategy.AtomicDiffusionImpl;
import diffusion.sensor.strategy.Diffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	public static void main(String[] args) {
		Diffusion atomicDiffusion = new AtomicDiffusionImpl();
		
		Sensor sensor = new SensorImpl(atomicDiffusion);
		Display display = new DisplayImpl();
		Channel channel = new Channel(sensor, display);
		
		atomicDiffusion.setChannel(channel);
		
		
		sensor.attach(display);
	}
}
