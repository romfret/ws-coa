package diffusion.display;

import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDisplay extends IObserver<ISensor> {
	
	public void update(ISensor subject);

}
