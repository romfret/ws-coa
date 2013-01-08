package diffusion.sensor.strategy;

import diffusion.sensor.ISensor;


/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDiffusion {
	public void configure(ISensor sensor);
	public void execute();
}
