package diffusion.sensor;

import java.util.ArrayList;
import java.util.List;

import diffusion.observer.Observer;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class SensorImpl implements Sensor {

	private List<Observer> observers;
	private int value;
	
	public SensorImpl() {
		observers = new ArrayList<Observer>();
	}
	
	public void attach(Observer o) {
		observers.add(o);
	}

	public void detach(Observer o) {
		observers.remove(o);
	}

	public void updateObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}

	public int getValue() {
		return value;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
