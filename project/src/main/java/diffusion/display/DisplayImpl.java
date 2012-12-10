package diffusion.display;

import diffusion.observer.Subject;
import diffusion.sensor.SensorImpl;

public class DisplayImpl implements Display {

	@Override
	public void update(Subject s) {
		// TODO
		System.out.println(((SensorImpl) s).getValue());
	}

	
}
