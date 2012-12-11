package diffusion.sensor;

import diffusion.observer.ISubject;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface ISensor extends ISubject {
	
	/**
	 * Get the sensor value
	 */
	public int getValue();
	
	/**
	 * Timer
	 */
	public void tick();
}
