package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class Update implements IUpdate {

	private String name;
	private ISensor sensor;
	private IDisplay display;
	
	public Object call() throws Exception {
		display.update(sensor); //display = le canal
		return null;
	}
	
	public void setObserver(IDisplay display) {
		this.display = display;
	}
	
	public void setSubject(ISensor sensor) {
		this.sensor = sensor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
