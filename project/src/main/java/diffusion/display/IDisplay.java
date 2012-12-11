package diffusion.display;

import diffusion.observer.Observer;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDisplay extends Observer<ISensor> {
	
	public void update(ISensor subject);

}
