package diffusion.display.ihm.command;

import diffusion.sensor.ISensor;

public class CommandDiffusion implements ICommandDiffusion {

	private ISensor sensor;
	
	public CommandDiffusion(ISensor sensor) {
		this.sensor = sensor;
	}
	
	public void execute(int diffusionId) {
		sensor.setDiffusion(diffusionId);
	}

}
