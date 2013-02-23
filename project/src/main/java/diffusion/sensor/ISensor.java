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
	
	/**
	 * Get the date of the value
	 * @return
	 */
	public long getVersion();

	/**
	 * Set diffusion strategy. diffusionId is App.ATOMIC_DIFFUSION or another
	 * @param diffusionId
	 */
	public void setDiffusion(int diffusionId);
}
