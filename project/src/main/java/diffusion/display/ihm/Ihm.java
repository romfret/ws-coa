package diffusion.display.ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;

import diffusion.display.IDisplay;

public class Ihm extends JFrame implements IIhm {
	
	public Ihm(){
		super("Notre plus belle IHM");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addDisplay(IDisplay display) {
		this.add((JPanel)display);
	}
}
