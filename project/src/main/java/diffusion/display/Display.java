package diffusion.display;

import utils.DisplayGUI;
import diffusion.sensor.ISensor;

public class Display implements IDisplay {
	
	private String name;
	private int value;
	
	private DisplayGUI displayGUI;

	public Display(String name) {
		this.name = name;
		displayGUI = new DisplayGUI(name);
	}

	public void update(ISensor s) {
		value = s.getValue(); 

		System.out.println(this);
		displayGUI.setValue(value);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {		
		return "[" + name + "] - [Sensor Value = " + value + "]";
	}
	
}
