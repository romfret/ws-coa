package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.observer.IObserver;
import diffusion.sensor.strategy.AtomicDiffusion;
import diffusion.sensor.strategy.IDiffusion;
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
		
		// Etablir une regle de choix de la strategie
		//diffusion = new SequentialDiffusion();
		diffusion = new AtomicDiffusion();
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
		value = (int) (Math.random()*100);
		
		diffusion.setSensorValue(value);
		diffusion.setVersion(version);
		
		updateObservers();
	}
	
	public long getVersion() {
		return diffusion.getVersion();
	}

	public void setDiffusion(int i){
		if(i==0){
			diffusion = new AtomicDiffusion();
		} else if (i==1){
			diffusion = new SequentialDiffusion();
		}
		diffusion.configure(this, observers);
	}
}
