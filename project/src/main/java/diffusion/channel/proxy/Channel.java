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
	private long time;
	
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
		
		time = (long) (500 + Math.random() * 2000);
		scheduler.schedule(update, time, TimeUnit.MILLISECONDS);
		
		System.out.println(this);
		
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
	public String toString() {
		String timeStr = "";
		if (time < 10)
			timeStr = "   " + Long.toString(time);
		else if (time < 100)
			timeStr = "  " + Long.toString(time);
		else  if (time < 1000)
			timeStr = " " + Long.toString(time);
		else
			timeStr = Long.toString(time);
		
		return "[" + name + "] - [" + timeStr + " ms] - [Sensor Value = " + subject.getValue() + "]";
	}

	@SuppressWarnings("rawtypes")
	public void attach(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	public void detach(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	public void updateObservers() {
		// TODO Auto-generated method stub
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
