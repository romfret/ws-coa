package diffusion.display.ihm;

import diffusion.display.ihm.command.ICommand;
import diffusion.display.ihm.command.ICommandDiffusion;


public interface IIhm {

	/**
	 * Add an sensor display
	 * @param displayGUI
	 */
	public void addDisplay(DisplayGUI displayGUI);
	
	/**
	 * Remove an sensor display
	 * @param display
	 */
	public void removeDisplay(DisplayGUI display);

	/**
	 * Set the command strategy selector
	 * @param diffusionCmd
	 */
	public void setCommandDiffusion(ICommandDiffusion diffusionCmd);
	
	/**
	 * Set the command for the add button in Ihm
	 * @param addDisplayCmd
	 */
	public void setCommandAddDisplay(ICommand addDisplayCmd);
	
	/**
	 * Set the command for the remove button in Ihm
	 * @param removeDisplayCmd
	 */
	public void setCommandRemoveDisplay(ICommand removeDisplayCmd);

}
