package diffusion.sensor.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
public class SequentialDiffusion implements IDiffusion {

	private int sensorValue;
	private long version;
	private boolean done;
	
	private ISensor sensor;
	private IProxyAO proxyAO;
	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	List<Future<?>> tasks;
	
	public SequentialDiffusion() {
		tasks = new ArrayList<Future<?>>();
		done = true;
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
		if (done) {
			tasks.clear();
			proxyAO = new ProxyAO();
			
			for (IObserver observer : observers) {
				tasks.add(proxyAO.createUpdateObject(sensor, (IDisplay)observer));
			}
		}
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.strategy.IDiffusion#setSensorValue(int)
	 */
	public void setSensorValue(int sensorValue) {
		testDone();
		if (done)
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
		if (done)
			this.version = version;
	}
	
	/**
	 * Test if all the display get the value without block the sensor
	 */
	@SuppressWarnings("unchecked")
	private void testDone() {
		done = true;
		for (Future<?> task : tasks) {
			try {
				Future<Object> future = (Future<Object>) ((Future<?>) task).get();
				if (!future.isDone())
					done = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
