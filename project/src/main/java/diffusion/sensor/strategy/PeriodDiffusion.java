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
	
	private int sensorValue;
	private long version;

	private ISensor sensor;
	private IProxyAO proxyAO;
	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	
	public PeriodDiffusion() {
		proxyAO = new ProxyAO();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#configure(diffusion.sensor.ISensor, java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	public void configure(ISensor sensor, List<IObserver> observers) {
		this.sensor = sensor;
		this.observers = observers;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#execute()
	 */
	@SuppressWarnings("rawtypes")
	public void execute() {
		for (IObserver observer : observers) {
			proxyAO.createUpdateObject(sensor, (IDisplay) observer);
		}
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#setSensorValue(int)
	 */
	public void setSensorValue(int sensorValue) {
		this.sensorValue = sensorValue;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#getSensorValue()
	 */
	public int getSensorValue() {
		return sensorValue;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#getVersion()
	 */
	public long getVersion() {
		return version;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#setVersion(long)
	 */
	public void setVersion(long version) {
		this.version = version;
	}
}
