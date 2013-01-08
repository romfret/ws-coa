package diffusion.channel.proxy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import diffusion.activeObject.IUpdate;
import diffusion.activeObject.Update;
import diffusion.display.IDisplay;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Channel implements ISensor, IDisplay {

	private String name;
	private ISensor subject;
	private IDisplay observer;
	private IUpdate update;
	
	public Channel(String name, IDisplay observer) {
		this.name = name;
		this.observer = observer;
	} 
	
	public void update(ISensor subject) {
		this.subject = subject;
		
		update = new Update();
		update.setName("Channel update instance");
		update.setObserver(observer);
		update.setSubject(this);
		
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		
		long time = (long) (500 + Math.random() * 500);
		scheduler.schedule(update, time, TimeUnit.MILLISECONDS);
		
		// L'observation faite via scheduler et l'instance update
//		observer.update(this);
	}

	public int getValue() {
		return subject.getValue();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void attach(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IObserver o) {
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
