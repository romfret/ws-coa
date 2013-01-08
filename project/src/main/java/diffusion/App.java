package diffusion;

import utils.Horloge;
import diffusion.channel.proxy.Channel;
import diffusion.display.IDisplay;
import diffusion.display.Display;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;
import diffusion.sensor.strategy.AtomicDiffusion;
import diffusion.sensor.strategy.IDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	public static void main(String[] args) {
		IDiffusion atomicDiffusion = new AtomicDiffusion();
		
		ISensor sensor = new Sensor(atomicDiffusion);
		IDisplay display = new Display("Display_1");
		Channel channel = new Channel("Chanel_1", display);
		
		((AtomicDiffusion)atomicDiffusion).setSensor(sensor);
		sensor.attach(channel);
		
		Horloge h = new Horloge();
		h.periodicallyActivate(sensor, 1000);
		
	}
}
