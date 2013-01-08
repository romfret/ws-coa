package diffusion.activeObject;

import diffusion.sensor.strategy.IDiffusion;

public interface IProxyAO {

	/**
	 * TODO :
	 */
	public abstract Future update(IDiffusion diffusion);

}