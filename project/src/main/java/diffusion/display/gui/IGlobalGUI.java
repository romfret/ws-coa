package diffusion.display.gui;

import java.util.List;

import diffusion.display.gui.command.ICommand;
import diffusion.display.gui.command.ICommandDiffusion;


public interface IGlobalGUI {

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
	 * Set the command for the add button in GUI
	 * @param addDisplayCmd
	 */
	public void setCommandAddDisplay(ICommand addDisplayCmd);
	
	/**
	 * Set the command for the remove button in GUI
	 * @param removeDisplayCmd
	 */
	public void setCommandRemoveDisplay(ICommand removeDisplayCmd);

	/**
	 * return the list of displays
	 */
	public List<DisplayGUI> getDisplays();

	/**
	 * return the diffusion command
	 * @return
	 */
	public ICommandDiffusion getCommandDiffusion();

	/**
	 * return the add display command
	 * @return
	 */
	public ICommand getCommandAddDisplay();

	/**
	 * return the remove display command
	 * @return
	 */
	public ICommand getCommandRemoveDisplay();

}
