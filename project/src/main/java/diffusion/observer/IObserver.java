package diffusion.observer;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface IObserver<T> {

	/**
	 * Update the observer with the given subject
	 */
	public Future<?> update(T subject);
}
