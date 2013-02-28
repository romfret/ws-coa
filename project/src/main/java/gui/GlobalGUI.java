package gui;
import gui.command.ICommand;
import gui.command.ICommandDiffusion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import diffusion.App;

public class GlobalGUI extends JFrame implements IGlobalGUI {
	private static final long serialVersionUID = 1L;

	private JPanel panelDisplay;
	private ICommandDiffusion diffusionCmd;
	private ICommand addDisplayCmd;
	private ICommand removeDisplayCmd;
	
	private JRadioButton atomicBtn;
	private JRadioButton periodBtn;
	private JRadioButton sequentialBtn;
	
	private JButton addBtn;
	private JButton delBtn;

	private List<DisplayGUI> displays;
	
	public GlobalGUI(){
		super("Our most beautiful GUI");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		displays = new ArrayList<DisplayGUI>();
		
		initView();
		configView();
		registerListeners();
	}
	
	protected void initView() {
		atomicBtn = new JRadioButton("Atomic");
		periodBtn = new JRadioButton("Period");
		sequentialBtn = new JRadioButton("Sequential");
		
		addBtn = new JButton("Add");
		delBtn = new JButton("Remove");
	}
	
	protected void configView() {
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(atomicBtn);
		radioButtonGroup.add(sequentialBtn);
		radioButtonGroup.add(periodBtn);
		// Default strategy button (if you want to change, change also the default strategy in Sensor)
		periodBtn.setSelected(true);
		
		JPanel panelBtnDisplay = new JPanel();
		panelBtnDisplay.setLayout(new BoxLayout(panelBtnDisplay, BoxLayout.Y_AXIS));
		panelBtnDisplay.setBorder(BorderFactory.createTitledBorder("Display"));
		panelBtnDisplay.add(addBtn);
		panelBtnDisplay.add(delBtn);
		
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		panelWest.add(atomicBtn);
		panelWest.add(sequentialBtn);
		panelWest.add(periodBtn);
		panelWest.add(panelBtnDisplay);
		
		this.add(panelWest, BorderLayout.WEST);
		
		panelDisplay = new JPanel();
		panelDisplay.setBackground(Color.BLACK);
		panelDisplay.setLayout(new FlowLayout());
		this.add(panelDisplay, BorderLayout.CENTER);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void registerListeners() {
		atomicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diffusionCmd.execute(App.ATOMIC_DIFFUSION);
			}
		});
		
		sequentialBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diffusionCmd.execute(App.SEQUENTIAL_DIFFUSION);
			}
		});
		
		periodBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diffusionCmd.execute(App.PERIOD_DIFFUSION);
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDisplayCmd.execute();
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeDisplayCmd.execute();
			}
		});
	}

	/* (non-Javadoc)
	 * @see diffusion.display.gui.IGlobalGUI#addDisplay(diffusion.display.ihm.DisplayGUI)
	 */
	public void addDisplay(DisplayGUI display) {
		displays.add(display);
		panelDisplay.add(display);
	}
	
	/* (non-Javadoc)
	 * @see diffusion.display.gui.IGlobalGUI#removeDisplay(diffusion.display.ihm.DisplayGUI)
	 */
	public void removeDisplay(DisplayGUI display) {
		displays.remove(display);
		panelDisplay.remove(display);
		panelDisplay.repaint();
	}

	/* (non-Javadoc)
	 * @see diffusion.display.gui.IGlobalGUI#setCommandDiffusion(diffusion.display.ihm.command.ICommandDiffusion)
	 */
	public void setCommandDiffusion(ICommandDiffusion diffusionCmd) {
		this.diffusionCmd = diffusionCmd;
	}

	/* (non-Javadoc)
	 * @see diffusion.display.gui.IGlobalGUI#setCommandAddDisplay(diffusion.display.ihm.command.ICommand)
	 */
	public void setCommandAddDisplay(ICommand addDisplayCmd) {
		this.addDisplayCmd = addDisplayCmd;
	}

	/* (non-Javadoc)
	 * @see diffusion.display.gui.IGlobalGUI#setCommandRemoveDisplay(diffusion.display.ihm.command.ICommand)
	 */
	public void setCommandRemoveDisplay(ICommand removeDisplayCmd) {
		this.removeDisplayCmd = removeDisplayCmd;
	}

	public List<DisplayGUI> getDisplays() {
		return displays;
	}

	public ICommandDiffusion getCommandDiffusion() {
		return diffusionCmd;
	}

	public ICommand getCommandAddDisplay() {
		return addDisplayCmd;
	}

	public ICommand getCommandRemoveDisplay() {
		return removeDisplayCmd;
	}

	
}
