package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.observer.IObserver;
import diffusion.sensor.strategy.AnarchicDiffusion;
import diffusion.sensor.strategy.IDiffusion;

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
		
		
		// Etablir une regle de choix de la strategie
		diffusion = new AnarchicDiffusion();
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
		return value;
	}

	public void tick() {
		version++;
		value = (int) (Math.random()*100);
		updateObservers();
	
	}
	
	public long getVersion() {
		return version;
	}

}
