package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public interface IProxyAO {

	/**
	 * TODO :
	 */
	public abstract Future update(ISensor sensor, IDisplay display);

}