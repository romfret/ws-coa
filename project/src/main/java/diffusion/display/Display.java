package diffusion.display;

import diffusion.observer.Observer;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface Display extends Observer<Sensor> {
	
	public void update(Sensor subject);

}
