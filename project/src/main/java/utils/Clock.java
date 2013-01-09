package utils;

import java.util.Timer;
import java.util.TimerTask;

import diffusion.sensor.ISensor;

public class Clock {

	private Timer timer = new Timer();

	public void periodicallyActivate(final ISensor sensor, double perdiodInMiliSeconds) {
		TimerTask task = new TimerTask() {
			public void run() {
				sensor.tick();
			}
		};
		timer.schedule(task, 0, (long) perdiodInMiliSeconds);
	}
}