package diffusion.display.ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ihm extends JFrame implements IIhm {
	private static final long serialVersionUID = 1L;

	private JPanel panelDisplay;
	
	public Ihm(){
		super("Notre plus belle IHM");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		
		ButtonGroup radioButtonGroup=new ButtonGroup();

		JRadioButton anarchicBtn = new JRadioButton("Anarchic");
		JRadioButton atomicBtn = new JRadioButton("Atomic");
		JRadioButton periodBtn = new JRadioButton("Period");
		JRadioButton sequentialBtn = new JRadioButton("Sequential");

		radioButtonGroup.add(anarchicBtn);
		radioButtonGroup.add(atomicBtn);
		radioButtonGroup.add(periodBtn);
		radioButtonGroup.add(sequentialBtn);
		
		panelWest.add(anarchicBtn);
		panelWest.add(atomicBtn);
		panelWest.add(periodBtn);
		panelWest.add(sequentialBtn);
		
		this.add(panelWest, BorderLayout.WEST);
		
		
		panelDisplay = new JPanel();
		panelDisplay.setLayout(new FlowLayout());
		this.add(panelDisplay, BorderLayout.CENTER);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addDisplay(DisplayGUI display) {
		
		panelDisplay.add(display);
	}
}
