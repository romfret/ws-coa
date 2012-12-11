package diffusion.display;

import diffusion.sensor.ISensor;

public class Display implements IDisplay {

	public void update(ISensor s) {
		// TODO
		System.out.println(s.getValue());
	}
	
}
