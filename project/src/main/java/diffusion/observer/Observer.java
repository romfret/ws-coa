package diffusion.observer;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public interface Observer {

	/**
	 * Update the observer with the given subject
	 */
	public void update(Subject s);
}
