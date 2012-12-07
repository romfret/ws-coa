package diffusion;

import diffusion.display.Display;
import diffusion.display.DisplayImpl;
import diffusion.sensor.Sensor;
import diffusion.sensor.SensorImpl;

public class App {
	public static void main(String[] args) {
		Sensor sensor = new SensorImpl();
		Display display = new DisplayImpl();
		
		
		
		sensor.attach(display);
	}
}
