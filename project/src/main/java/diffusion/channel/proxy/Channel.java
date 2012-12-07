package diffusion.channel.proxy;

import java.util.List;

import diffusion.display.Display;
import diffusion.observer.Observer;
import diffusion.observer.Subject;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Channel implements Sensor, Display {

	private Subject subject = null;
	
	public Channel(Subject subject) {
		this.subject = subject;
	}
	
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void updateObservers() {
		// TODO Auto-generated method stub
		
	}

	public void update(Subject s) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
