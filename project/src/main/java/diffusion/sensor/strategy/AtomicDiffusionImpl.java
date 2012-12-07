package diffusion.sensor.strategy;

import java.nio.channels.Channel;

import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class AtomicDiffusionImpl implements Diffusion {

	private Sensor sensor;
	private Channel channel;
	
	public AtomicDiffusionImpl(Sensor sensor, Channel channel) {
		this.sensor = sensor;
		this.channel = channel;
	}

	public void configure() {

	}

	public void execute() {

	}
}
