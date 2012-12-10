package utils;

import java.util.Timer;
import java.util.TimerTask;

import diffusion.sensor.Sensor;

public class Horloge {

	private Timer timer = new Timer();

	public void periodicallyActivate(final Sensor sensor, double perdiodInMiliSeconds) {
		TimerTask task = new TimerTask() {
			public void run() {
				sensor.tick();
			}
		};
		timer.schedule(task, 0, (long) perdiodInMiliSeconds);
	}
}