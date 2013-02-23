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

		// Default strategy (if you want to change, change also the default button in Ihm)
		diffusion = new PeriodDiffusion();
		diffusion.configure(this, observers);
	}

	@SuppressWarnings("rawtypes")
	public void attach(IObserver o) {
		observers.add(o);
	}

	@SuppressWarnings("rawtypes")
	public void detach(IObserver o) {
		observers.remove(o);
	}

	public void updateObservers() {
		diffusion.execute();
	}

	public int getValue() {
		return diffusion.getSensorValue();
	}

	public void tick() {
		System.out.println("Tick");
		version++;
		value = (int) (Math.random() * 100);

		diffusion.setSensorValue(value);
		diffusion.setVersion(version);

		updateObservers();
	}

	public long getVersion() {
		return diffusion.getVersion();
	}

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
			System.out.println("Diffusion strategy unrecognized");
			break;
		}

		diffusion.configure(this, observers);
	}
}
