package diffusion.observer;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface Subject {

	/**
	 * Add an observer to the subject
	 */
	public void attach(Observer o);
	
	/**
	 * Remove an observer to the subject
	 */
	public void detach(Observer o);
	
	/**
	 * Notify the observers
	 */
	public void updateObservers();
}
