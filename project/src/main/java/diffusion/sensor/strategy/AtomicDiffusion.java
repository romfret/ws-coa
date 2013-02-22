package diffusion.sensor.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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
public class AtomicDiffusion implements IDiffusion {

	private int sensorValue;
	private long version;
	
	private ISensor sensor;
	private IProxyAO proxyAO;
	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	List<Future<?>> tasks;
	
	public AtomicDiffusion() {
		tasks = new ArrayList<Future<?>>();
	}

	@SuppressWarnings("rawtypes")
	public void configure(ISensor sensor, List<IObserver> observers) {
		this.sensor = sensor;
		this.observers = observers;
	}

	@SuppressWarnings("rawtypes")
	public void execute() {
		tasks.clear();
		proxyAO = new ProxyAO();
		
		for (IObserver observer : observers) {
			tasks.add(proxyAO.createUpdateObject(sensor, (IDisplay)observer));
		}
		
		try {
			// Attente passive
			((ProxyAO) proxyAO).invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void setSensorValue(int sensorValue) {
		this.sensorValue = sensorValue;
	}

	public int getSensorValue() {
		return sensorValue;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
