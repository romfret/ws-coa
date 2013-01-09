package diffusion.display;

import diffusion.display.ihm.DisplayGUI;
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
		String valueStr = "";
		if (value < 10)
			valueStr = " " + Integer.toString(value);
		else
			valueStr = Integer.toString(value);
		
		return "[" + name + "] - [Sensor Value = " + valueStr + "]";
	}

	public DisplayGUI getPresentation() {
		return displayGUI;
	}
	
}
