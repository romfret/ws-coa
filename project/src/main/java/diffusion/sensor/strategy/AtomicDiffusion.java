package diffusion.sensor.strategy;

import java.util.List;

import diffusion.activeObject.IProxyAO;
import diffusion.activeObject.ProxyAO;
import diffusion.observer.IObserver;
import diffusion.sensor.ISensor;

/**
 * 
 * @author Douchement & Le Ho
 * 
 */
public class AtomicDiffusion implements IDiffusion {

	private ISensor sensor;
	private IProxyAO proxyAO;
	private List<IObserver> observers;
	
	public AtomicDiffusion() {
		proxyAO = new ProxyAO();
	}

	public void configure(ISensor sensor, List<IObserver> observers) {
		this.sensor = sensor;
		this.observers = observers;
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
		
		//sensor.updateObservers();
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
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

}
