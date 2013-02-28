package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.App;
import diffusion.observer.IObserver;
import diffusion.sensor.strategy.AtomicDiffusion;
import diffusion.sensor.strategy.IDiffusion;
import diffusion.sensor.strategy.PeriodDiffusion;
import diffusion.sensor.strategy.SequentialDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 * 
 */
public class Sensor implements ISensor {

	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	private IDiffusion diffusion;
	private int value;
	private long version;

	@SuppressWarnings("rawtypes")
	public Sensor() {
		observers = new ArrayList<IObserver>();

		// Default strategy (if you want to change, change also the default button in GUI)
		diffusion = new PeriodDiffusion();
		diffusion.configure(this, observers);
	}

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#attach(diffusion.observer.IObserver)
	 */
	@SuppressWarnings("rawtypes")
	public void attach(IObserver o) {
		observers.add(o);
	}

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#detach(diffusion.observer.IObserver)
	 */
	@SuppressWarnings("rawtypes")
	public void detach(IObserver o) {
		observers.remove(o);
	}

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#updateObservers()
	 */
	public void updateObservers() {
		diffusion.execute();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getValue()
	 */
	public int getValue() {
		return diffusion.getSensorValue();
	}
	
	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getRealSensorValue()
	 */
	public int getRealSensorValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#tick()
	 */
	public void tick() {
		System.out.println("== Sensor value changed ==");
		version++;
		value = (int) (Math.random() * 100);

		diffusion.setSensorValue(value);
		diffusion.setVersion(version);

		updateObservers();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getVersion()
	 */
	public long getVersion() {
		return diffusion.getVersion();
	}
	
	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getRealSensorVersion()
	 */
	public long getRealSensorVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#setDiffusion(int)
	 */
	public void setDiffusion(int diffusionId) {
		switch (diffusionId) {
		case App.ATOMIC_DIFFUSION:
			diffusion = new AtomicDiffusion();
			System.out.println("========================== ATOMIC");
			break;
		case App.SEQUENTIAL_DIFFUSION:
			diffusion = new SequentialDiffusion();
			System.out.println("========================== SEQ");
			break;
		case App.PERIOD_DIFFUSION:
			diffusion = new PeriodDiffusion();
			System.out.println("========================== PERIOD");
			break;
		default:
			System.err.println("Diffusion strategy unrecognized");
			break;
		}

		diffusion.configure(this, observers);
	}
	
	public IDiffusion getDiffusion() {
		return diffusion;
	}
}
