package diffusion.display;

import java.util.concurrent.Future;

import diffusion.activeObject.IUpdate;
import diffusion.display.ihm.DisplayGUI;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDisplay extends IObserver<ISensor> {
	
	public Future<?> update(ISensor sensor);
	
	public String getName();

	public DisplayGUI getPresentation();

	public IUpdate createUpdate(ISensor sensor);
	
	public int getValue();

}
