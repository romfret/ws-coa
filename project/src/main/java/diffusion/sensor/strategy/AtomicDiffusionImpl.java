package diffusion.sensor.strategy;

import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 * 
 */
public class AtomicDiffusionImpl implements Diffusion {

	private Sensor sensor;

	public AtomicDiffusionImpl() {
	}

	public void configure() {

	}

	public void execute() {
		sensor.updateObservers();
	}
	
	public void setSensor(Sensor sensor){
		this.sensor = sensor;
	}
}
