package diffusion.channel.proxy;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import diffusion.activeObject.IUpdate;
import diffusion.activeObject.Update;
import diffusion.display.IDisplay;
import diffusion.display.ihm.DisplayGUI;
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
	private ScheduledExecutorService scheduler;
	
	public Channel(String name, IDisplay observer) {
		this.name = name;
		this.observer = observer;
		
		scheduler = Executors.newScheduledThreadPool(10);
	} 
	
	public IUpdate createUpdate(ISensor sensor) {
		this.subject = sensor;
		update = new Update();
		update.setName("Channel update instance");
		update.setObserver(observer);
		update.setSubject(this);
		return update;
	}
	
	public Future<?> update(ISensor subject) {
		
		time = (long) (500 + Math.random() * 10000);
		Future<Object> future = scheduler.schedule(update, time, TimeUnit.MILLISECONDS);
		
		System.out.println(this);
		
		
		return future;
	}

	public int getValue() {
		return subject.getValue();
	}
	
	public String getName() {
		return name;
	}
	
	public long getVersion() {
		return subject.getVersion();
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
		
		
		int value =  subject.getValue();
		String valueStr = "";
		if (value < 10)
			valueStr = " " + Integer.toString(value);
		else
			valueStr = Integer.toString(value);
		
		return "[" + name + "] - [Sensor Value = " + valueStr + "] - [Version : " + subject.getVersion() + "] - [" + timeStr + " ms]";
	}

	@SuppressWarnings("rawtypes")
	public void attach(IObserver o) {
		subject.attach(o);
	}

	@SuppressWarnings("rawtypes")
	public void detach(IObserver o) {
		subject.detach(o);
	}

	public void updateObservers() {
		subject.updateObservers();
	}

	public void tick() {
		subject.tick();
	}

	public DisplayGUI getPresentation() {
		return observer.getPresentation();
	}



	public void update() {
		// TODO Auto-generated method stub
		
	}




}
