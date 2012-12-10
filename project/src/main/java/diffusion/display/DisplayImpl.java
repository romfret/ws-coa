package diffusion.display;

import diffusion.observer.Subject;
import diffusion.sensor.Sensor;

public class DisplayImpl implements Display {

	public void update(Sensor s) {
		// TODO
		System.out.println(s.getValue());
	}

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		
	}

	
}
