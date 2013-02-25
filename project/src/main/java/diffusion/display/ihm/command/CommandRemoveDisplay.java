package diffusion.display.ihm.command;

import diffusion.App;


public class CommandRemoveDisplay implements ICommand {

	public void execute() {
		App.removeDisplay();
	}

}
