package diffusion.activeObject;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class Update implements IUpdate {

	private String name;
	private ISensor sensor;
	private IDisplay display;
	
	public Object call() throws Exception {
		display.createUpdate(sensor);
		return display.update(sensor);
	}
	
	/* (non-Javadoc)
	 * @see diffusion.activeObject.IUpdate#setObserver(diffusion.display.IDisplay)
	 */
	public void setObserver(IDisplay display) {
		this.display = display;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.activeObject.IUpdate#setSubject(diffusion.sensor.ISensor)
	 */
	public void setSubject(ISensor sensor) {
		this.sensor = sensor;
	}

	/* (non-Javadoc)
	 * @see diffusion.activeObject.IUpdate#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see diffusion.activeObject.IUpdate#getName()
	 */
	public String getName() {
		return name;
	}
}
