package diffusion.channel.proxy;

import diffusion.display.Display;
import diffusion.observer.Observer;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Channel implements Sensor, Display {

	private Sensor subject;
	private Display observer;
	
	public Channel(Sensor subject, Display observer) {
		this.subject = subject;
		this.observer = observer;
	}
	
	public void update(Sensor s) {
		observer.update(this);
	}

	public int getValue() {
		return subject.getValue();
	}

	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
