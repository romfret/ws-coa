package diffusion.display.gui.command;

import diffusion.App;


public class CommandRemoveDisplay implements ICommand {

	/* (non-Javadoc)
	 * @see diffusion.display.gui.command.ICommand#execute()
	 */
	public void execute() {
		App.removeDisplay();
	}

}
