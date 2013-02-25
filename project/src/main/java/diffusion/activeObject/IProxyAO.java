package diffusion.activeObject;

import java.util.List;
import java.util.concurrent.Future;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public interface IProxyAO {

	/**
	 * Create a new Update object
	 */
	public abstract Future<?> createUpdateObject(ISensor sensor, IDisplay display);
	
	/**
	 * Passive waiting for all observer's getValue() complete
	 */
	public List<Future<Object>> invokeAll(List<Future<?>> tasks) throws InterruptedException;

}