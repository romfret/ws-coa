package diffusion.sensor.strategy;

import java.util.List;

import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;


/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDiffusion {
	public void configure(ISensor sensor, @SuppressWarnings("rawtypes") List<IObserver> observers);
	public void execute();
}
