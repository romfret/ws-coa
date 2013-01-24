package diffusion.sensor.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import diffusion.activeObject.IProxyAO;
import diffusion.activeObject.ProxyAO;
import diffusion.display.IDisplay;
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
	@SuppressWarnings("rawtypes")
	private List<IObserver> observers;
	List<Future<?>> tasks;
	
	public AtomicDiffusion() {
		tasks = new ArrayList<Future<?>>();
	}

	@SuppressWarnings("rawtypes")
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

	@SuppressWarnings("rawtypes")
	public void execute() {
		tasks.clear();
		proxyAO = new ProxyAO();
		
		
		for (IObserver observer : observers) {
			tasks.add(proxyAO.createUpdateObject(sensor, (IDisplay)observer));
		}
		
		
		try {
			// Attente passive
			((ProxyAO) proxyAO).invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
//		// attendre les display
//		for (Future<?> task : tasks){
//			try {
//				while(! ( (Future<?>) task.get() ).isDone() ){}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			};
//		}
		
		System.out.println("==============================================================================");

		
		
	}

}
