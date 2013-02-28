package diffusion.sensor.strategy;

import java.util.List;

import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;


/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IDiffusion {
	/**
	 * configure the strategy with a sensor and a list of observers
	 * @param sensor
	 * @param observers
	 */
	public void configure(ISensor sensor, @SuppressWarnings("rawtypes") List<IObserver> observers);
	
	/**
	 * diffuse a value with a specific strategy
	 */
	public void execute();
	
	/**
	 * Set the sensor value in strategy
	 * @param sensorValue
	 */
	public void setSensorValue(int sensorValue);
	
	/**
	 * Get the sensor value in strategy
	 * @return
	 */
	public int getSensorValue();
	
	/**
	 * Set the sensor value version in strategy
	 * @param version
	 */
	public void setVersion(long version);
	
	/**
	 * Get the sensor value version in strategy
	 * @return
	 */
	public long getVersion();
}
