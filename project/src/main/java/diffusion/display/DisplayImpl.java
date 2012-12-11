package diffusion.display;

import diffusion.sensor.Sensor;

public class DisplayImpl implements Display {

	public void update(Sensor s) {
		// TODO
		System.out.println(s.getValue());
	}
	
}
