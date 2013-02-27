package diffusion.sensor;

import diffusion.observer.ISubject;
import diffusion.sensor.strategy.IDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface ISensor extends ISubject {
	
	/**
	 * Get the sensor value (the value in the strategy)
	 */
	public int getValue();
	
	/**
	 * Get the sensor value (the real sensor value)
	 * @return
	 */
	public int getRealSensorValue();
	
	/**
	 * Timer
	 */
	public void tick();
	
	/**
	 * Get the date of the value (the value in the strategy)
	 * @return
	 */
	public long getVersion();
	
	/**
	 * Get the date of the value (the real sensor value)
	 * @return
	 */
	public long getRealSensorVersion();

	/**
	 * Set diffusion strategy. diffusionId is App.ATOMIC_DIFFUSION or another
	 * @param diffusionId
	 */
	public void setDiffusion(int diffusionId);
	
	/**
	 * Return the instanced strategy
	 * @return
	 */
	public IDiffusion getDiffusion();
}
