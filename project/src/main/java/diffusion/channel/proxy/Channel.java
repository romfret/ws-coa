package diffusion.channel.proxy;

import diffusion.display.IDisplay;
import diffusion.observer.Observer;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Channel implements ISensor, IDisplay {

	private ISensor subject;
	private IDisplay observer;
	
	public Channel(ISensor subject, IDisplay observer) {
		this.subject = subject;
		this.observer = observer;
	}
	
	public void update(ISensor s) {
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
