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
import diffusion.sensor.strategy.IDiffusion;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class Channel implements IChannel {

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
	
	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#createUpdate(diffusion.sensor.ISensor)
	 */
	public IUpdate createUpdate(ISensor sensor) {
		this.subject = sensor;
		update = new Update();
		update.setName("Channel update instance");
		update.setObserver(observer);
		update.setSubject(this);
		return update;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#update(diffusion.sensor.ISensor)
	 */
	public Future<?> update(ISensor subject) {
		time = (long) (500 + Math.random() * 10000);
		Future<Object> future = scheduler.schedule(update, time, TimeUnit.MILLISECONDS);
		
		System.out.println(this);
		
		return future;
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getValue()
	 */
	public int getValue() {
		return subject.getValue();
	}
	
	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getVersion()
	 */
	public long getVersion() {
		return subject.getVersion();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#attach(diffusion.observer.IObserver)
	 */
	@SuppressWarnings("rawtypes")
	public void attach(IObserver o) {
		subject.attach(o);
	}

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#detach(diffusion.observer.IObserver)
	 */
	@SuppressWarnings("rawtypes")
	public void detach(IObserver o) {
		subject.detach(o);
	}

	/* (non-Javadoc)
	 * @see diffusion.observer.ISubject#updateObservers()
	 */
	public void updateObservers() {
		subject.updateObservers();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#tick()
	 */
	public void tick() {
		subject.tick();
	}

	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#getPresentation()
	 */
	public DisplayGUI getPresentation() {
		return observer.getPresentation();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#setDiffusion(int)
	 */
	public void setDiffusion(int diffusionId) {
		subject.setDiffusion(diffusionId);
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getRealSensorValue()
	 */
	public int getRealSensorValue() {
		System.out.println(subject);
		return subject.getRealSensorValue();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getRealSensorVersion()
	 */
	public long getRealSensorVersion() {
		return subject.getRealSensorVersion();
	}

	/* (non-Javadoc)
	 * @see diffusion.sensor.ISensor#getDiffusion()
	 */
	public IDiffusion getDiffusion() {
		return subject.getDiffusion();
	}

}
