package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.observer.Observer;
import diffusion.sensor.strategy.IDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Sensor implements ISensor {

	@SuppressWarnings("rawtypes")
	private List<Observer> observers;
	private IDiffusion diffusion;
	private int value;
	
	@SuppressWarnings("rawtypes")
	public Sensor(IDiffusion diffusion) {
		observers = new ArrayList<Observer>();
		this.diffusion = diffusion;
	}
	
	@SuppressWarnings("rawtypes")
	public void attach(Observer o) {
		observers.add(o);
	}

	@SuppressWarnings("rawtypes")
	public void detach(Observer o) {
		observers.remove(o);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateObservers() {
		for (Observer o : observers) {
			// TODO : bug avec methodes update() des interfaces Observer et Display => le parametre est different d'ou l'obligation de cast
			o.update(this);
		}
	}

	public int getValue() {
		return value;
	}

	public void tick() {
		value = (int) (Math.random()*100);
		diffusion.execute();
		//updateObservers();
		
	}

}
