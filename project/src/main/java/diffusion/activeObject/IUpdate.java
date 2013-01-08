package diffusion.activeObject;

import java.util.concurrent.Callable;

import diffusion.display.IDisplay;
import diffusion.sensor.strategy.IDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IUpdate extends Callable<Object> {
	
	/**
	 * Set the observer of type IDislay
	 */
	public void setObserver(IDisplay display);
	
	/**
	 * Set the subject of type ISensor
	 */
	public void setSubject(IDiffusion diffusion);
	
	/**
	 * Set the name of the Update instance
	 */
	public void setName(String name);
	
	/**
	 * Get the name of the Update instance
	 */
	public String getName();
}
