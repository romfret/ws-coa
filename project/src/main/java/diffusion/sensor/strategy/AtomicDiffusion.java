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
	
	/**
	 * TODO :
	 * Voir PC Strategy sur developpez.com. PC ayant pour but de faire varier une partie de l'algo du context suivant une strategie.
	 * => C'est lors de l'instanciation du context (Sensor) qu'une strategie lui est passee en parametre.
	 * C'est le context qui lancera la strategie :
	 * 
	 * // Dans Sensor 
	 * public void operation() {
	 * 		strategie.operationSpecifiqueDeDiffusion(); // Diffusion atomique, sequentiel et epoque suivant la strategie. 
	 * }
	 * 
	 */

	public void execute() {
		sensor.updateObservers();
	}
	
	public void setSensor(ISensor sensor){
		this.sensor = sensor;
	}
	
}