package diffusion.sensor;

import diffusion.observer.Subject;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface ISensor extends Subject {
	
	/**
	 * Get the sensor value
	 */
	public int getValue();
	
	/**
	 * Timer
	 */
	public void tick();
}
