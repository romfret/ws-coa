package diffusion.sensor.strategy;

import diffusion.channel.proxy.Channel;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class AtomicDiffusionImpl implements Diffusion {

	private Sensor sensor;
	private Channel channel;
	
	public AtomicDiffusionImpl(Channel channel) {
		this.channel = channel;
	}

	public void configure() {

	}

	public void execute() {
		
	}
}
