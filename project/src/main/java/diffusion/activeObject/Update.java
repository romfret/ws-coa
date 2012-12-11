package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class Update implements IUpdate {

	private ISensor sensor;
	private IDisplay display;
	
	public Object call() throws Exception {
		display.update(sensor);
		return null;
	}
	
	public void setObserver(IDisplay display) {
		this.display = display;
	}
	
	public void setSubject(ISensor sensor) {
		this.sensor = sensor;
	}
}
