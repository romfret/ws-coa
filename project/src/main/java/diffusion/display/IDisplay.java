package diffusion.display;

import diffusion.display.ihm.DisplayGUI;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDisplay extends IObserver<ISensor> {
	
	public void update(ISensor subject);
	
	public String getName();

	public DisplayGUI getPresentation();

}
