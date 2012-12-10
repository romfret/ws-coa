package diffusion.sensor.strategy;

import diffusion.channel.proxy.Channel;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface Diffusion {
	public void configure();
	public void execute();
	public void setChannel(Channel channel);
}
