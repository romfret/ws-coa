package diffusion.activeObject;

import java.util.concurrent.Callable;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class Update implements Callable<Object> {

	private ISensor sensor;
	private IDisplay display;
	
	public Object call() throws Exception {
		display.update(sensor);
		return null;
	}
	
	/**
	 * Set the observer of type Dislay
	 */
	public void setObserver(IDisplay display) {
		this.display = display;
	}
	
	/**
	 * Set the subject of type Sensor
	 */
	public void setSubject(Sensor sensor) {
		this.sensor = sensor;
	}

}
