package diffusion.activeObject;

import java.util.concurrent.Future;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public interface IProxyAO {

	/**
	 * TODO :
	 */
	public abstract Future<?> createUpdateObject(ISensor sensor, IDisplay display);

}