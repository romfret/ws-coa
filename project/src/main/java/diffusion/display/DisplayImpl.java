package diffusion.display;

import diffusion.observer.Subject;
import diffusion.sensor.SensorImpl;

public class DisplayImpl implements Display {

	@Override
	public void update(Subject s) {
		// TODO
		((SensorImpl) s).getValue();
	}

	
}
