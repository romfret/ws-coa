package diffusion.activeObject;

import java.util.concurrent.Callable;

import diffusion.display.Display;
import diffusion.sensor.Sensor;

public class Update implements Callable<Object> {

	private Sensor sensor;
	private Display display;
	
	public Object call() throws Exception {
		display.update(sensor);
		return null;
	}
	
	/**
	 * Set the observer of type Dislay
	 */
	public void setObserver(Display display) {
		this.display = display;
	}
	
	/**
	 * Set the subject of type Sensor
	 */
	public void setSubject(Sensor sensor) {
		this.sensor = sensor;
	}

}
