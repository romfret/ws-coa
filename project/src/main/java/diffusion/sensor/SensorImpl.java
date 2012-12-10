package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.display.Display;
import diffusion.observer.Observer;
import diffusion.sensor.strategy.Diffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class SensorImpl implements Sensor {

	private List<Observer> observers;
	private Diffusion diffusion;
	private int value;
	
	public SensorImpl(Diffusion diffusion) {
		observers = new ArrayList<Observer>();
		this.diffusion = diffusion;
	}
	
	public void attach(Observer o) {
		observers.add(o);
	}

	public void detach(Observer o) {
		observers.remove(o);
	}

	public void updateObservers() {
		for (Observer o : observers) {
			// TODO : bug avec methodes update() des interfaces Observer et Display => le parametre est different d'ou l'obligation de cast
			((Display) o).update(this);
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
