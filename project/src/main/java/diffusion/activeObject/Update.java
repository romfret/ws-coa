package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.strategy.IDiffusion;

public class Update implements IUpdate {

	private String name;
	private IDiffusion diffusion;
	private IDisplay display;
	
	public Object call() throws Exception {
		//display.update(diffusion);
		return null;
	}
	
	public void setObserver(IDisplay display) {
		this.display = display;
	}
	
	public void setSubject(IDiffusion diffusion) {
		this.diffusion = diffusion;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
