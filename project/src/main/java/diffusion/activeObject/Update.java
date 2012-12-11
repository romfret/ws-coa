package diffusion.activeObject;

import java.util.concurrent.Callable;

import diffusion.display.Display;
import diffusion.sensor.Sensor;

public class Update implements Callable<Object> {

	private Sensor sensor;
	private Display display;
	
	public Object call() throws Exception {
		return null;
	}
	
	/**
	 * 
	 */
	public void setObserver(Display display) {
		this.display = display;
	}

}
