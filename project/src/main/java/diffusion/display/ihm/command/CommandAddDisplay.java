package diffusion.display.ihm.command;

import diffusion.App;

public class CommandAddDisplay implements ICommand {

	/* (non-Javadoc)
	 * @see diffusion.display.ihm.command.ICommand#execute()
	 */
	public void execute() {
		App.addDisplay();
	}

}
