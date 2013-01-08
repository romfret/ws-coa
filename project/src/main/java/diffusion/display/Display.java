package diffusion.display;

import diffusion.sensor.ISensor;

public class Display implements IDisplay {
	
	private String name;

	public Display(String name) {
		this.name = name;
	}

	public void update(ISensor s) {
		// TODO
		System.out.println(name + " - " + s.getValue());
	}

	public String getName() {
		return name;
	}
	
}
