package diffusion.sensor.strategy;

import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 * 
 */
public class AtomicDiffusion implements IDiffusion {

	private ISensor sensor;
	
	public AtomicDiffusion() {
		
	}

	public void configure() {

	}

	public void execute() {
		sensor.updateObservers();
	}
	
	public void setSensor(ISensor sensor){
		this.sensor = sensor;
	}
	
}
