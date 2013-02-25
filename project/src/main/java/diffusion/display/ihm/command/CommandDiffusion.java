package diffusion.display.ihm.command;

import diffusion.sensor.ISensor;

public class CommandDiffusion implements ICommandDiffusion {

	private ISensor sensor;
	
	public CommandDiffusion(ISensor sensor) {
		this.sensor = sensor;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.display.ihm.command.ICommandDiffusion#execute(int)
	 */
	public void execute(int diffusionId) {
		sensor.setDiffusion(diffusionId);
	}

}
