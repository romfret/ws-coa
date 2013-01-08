package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLabel;

	public DisplayGUI(String name) {
		setVisible(true);
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
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
