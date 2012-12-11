package diffusion.activeObject;

import java.util.concurrent.Callable;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IUpdate extends Callable<Object>  {
	
	/**
	 * Set the observer of type IDislay
	 */
	public void setObserver(IDisplay display);
	
	/**
	 * Set the subject of type ISensor
	 */
	public void setSubject(ISensor sensor);
}
