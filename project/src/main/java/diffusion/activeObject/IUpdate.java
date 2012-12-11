package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IUpdate {
	
	/**
	 * Set the observer of type IDislay
	 */
	public void setObserver(IDisplay display);
	
	/**
	 * Set the subject of type ISensor
	 */
	public void setSubject(ISensor sensor);
}
