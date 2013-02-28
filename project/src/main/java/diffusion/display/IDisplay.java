package diffusion.display;

import java.util.concurrent.Future;

import diffusion.activeObject.IUpdate;
import diffusion.display.gui.DisplayGUI;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDisplay extends IObserver<ISensor> {
	/**
	 * return the name of the display
	 * @return
	 */
	public String getName();

	/**
	 * return the current value of the display
	 * @return
	 */
	public int getValue();
	
	/**
	 * return the current version of the display
	 * @return
	 */
	public long getVersion();
	
	/**
	 * return the presentation
	 * @return
	 */
	public DisplayGUI getPresentation();

	/**
	 * return a null update object
	 * @param sensor
	 * @return
	 */
	public IUpdate createUpdate(ISensor sensor);
	
	/**
	 * update value and version in the presentation
	 */
	public Future<?> update(ISensor sensor);
}
