package diffusion.sensor.strategy;

import java.util.List;

import diffusion.activeObject.IProxyAO;
import diffusion.activeObject.ProxyAO;
import diffusion.display.IDisplay;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class PeriodDiffusion implements IDiffusion {

	private ISensor sensor;
	private IProxyAO proxyAO;
	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	
	public PeriodDiffusion() {
		proxyAO = new ProxyAO();
	}

	@SuppressWarnings("rawtypes")
	public void configure(ISensor sensor, List<IObserver> observers) {
		this.sensor = sensor;
		this.observers = observers;
	}

	@SuppressWarnings("rawtypes")
	public void execute() {
		for (IObserver observer : observers) {
			proxyAO.createUpdateObject(sensor, (IDisplay)observer);
		}
	}
}
