package diffusion.display.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLabel;

	public DisplayGUI(String name) {
		setVisible(true);
		setBounds(100, 100, 250, 100);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.BLACK);
		
		lblLabel = new JLabel("label", JLabel.CENTER);
		lblLabel.setBackground(Color.BLACK);
		lblLabel.setForeground(Color.RED);
		lblLabel.setFont(new Font("Impact", Font.BOLD, 48));
		contentPane.add(lblLabel, BorderLayout.CENTER);
	}
	
	public void setValue(int number) {
		lblLabel.setText(String.valueOf(number));
	}

}
