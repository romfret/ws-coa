package diffusion.display;

import diffusion.display.ihm.DisplayGUI;
import diffusion.sensor.ISensor;

public class Display implements IDisplay {
	
	private String name;
	private int value;
	public long version;
	
	private DisplayGUI displayGUI;

	public Display(String name) {
		this.name = name;
		displayGUI = new DisplayGUI(name);
	}

	public void update(ISensor s) {
		value = s.getValue();
		version = s.getVersion();

		System.out.println(this);
		displayGUI.setValue(value);
		displayGUI.setVersion(version);
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
		
		return "[" + name + "] - [Sensor Value = " + valueStr + "] - [Version : " + version + "]";
	}

	public DisplayGUI getPresentation() {
		return displayGUI;
	}
	
}
