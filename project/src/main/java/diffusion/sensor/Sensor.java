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
//		for (IObserver o : observers) {
//			// TODO : bug avec methodes update() des interfaces Observer et Display => le parametre est different d'ou l'obligation de cast
//			o.update(this);
//		}
		
		diffusion.execute();
	}

	public int getValue() {
		return value;
	}

	public void tick() {
		value = (int) (Math.random()*100);
		updateObservers();
	
	}

}
