package diffusion.observer;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface Observer<T> {

	/**
	 * Update the observer with the given subject
	 */
	public void update(T subject);
}
