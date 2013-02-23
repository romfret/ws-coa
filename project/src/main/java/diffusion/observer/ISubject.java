package diffusion.observer;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface ISubject {

	/**
	 * Add an observer to the subject
	 */
	public void attach(IObserver<?> o);
	
	/**
	 * Remove an observer to the subject
	 */
	public void detach(IObserver<?> o);
	
	/**
	 * Notify the observers
	 */
	public void updateObservers();
}
