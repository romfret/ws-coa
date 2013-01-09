package diffusion.display.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblValue;
	private JLabel lblName;

	public DisplayGUI(String name) {
		setVisible(true);
		setSize(250, 200);
		setPreferredSize(getSize());
		
		
//		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBorder(BorderFactory.createMatteBorder(
                3, 3, 3, 3, Color.GREEN));
		this.setLayout(new BorderLayout(3, 3));
		this.setBackground(Color.BLACK);
		
		lblName = new JLabel(name, JLabel.CENTER);
		
		lblValue = new JLabel("label", JLabel.CENTER);
		lblValue.setBackground(Color.BLACK);
		lblValue.setForeground(Color.RED);
		lblValue.setFont(new Font("Impact", Font.BOLD, 48));
		
		
		this.add(lblValue, BorderLayout.CENTER);
	}
	
	public void setValue(int number) {
		lblValue.setText(String.valueOf(number));
	}

}
