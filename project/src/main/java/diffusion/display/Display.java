package diffusion.display;

import javax.swing.JFrame;

import utils.DisplayGUI;

import diffusion.sensor.ISensor;

public class Display implements IDisplay {
	
	private String name;
	
	private DisplayGUI displayGUI;

	public Display(String name) {
		this.name = name;
		displayGUI = new DisplayGUI(name);
	}

	public void update(ISensor s) {
		// TODO
		System.out.println(name + " - " + s.getValue());
		displayGUI.setValue(s.getValue());
	}

	public String getName() {
		return name;
	}
	
}
