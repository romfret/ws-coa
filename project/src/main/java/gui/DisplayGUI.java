package gui;

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
	private JLabel lblVersion;
	private int value;
	private long version;

	public DisplayGUI(String name) {
		setVisible(true);
		setSize(200, 150);
		setPreferredSize(getSize());
		
		this.setBorder(BorderFactory.createMatteBorder(
                2, 2, 2, 2, Color.GREEN));
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.BLACK);
		
		lblName = new JLabel(name, JLabel.CENTER);
		lblName.setBackground(Color.BLACK);
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("Impact", Font.BOLD, 14));
		
		lblValue = new JLabel("Null  ", JLabel.RIGHT);
		lblValue.setBackground(Color.BLACK);
		lblValue.setForeground(Color.RED);
		lblValue.setFont(new Font("Impact", Font.BOLD, 48));
		
		lblVersion = new JLabel("  Version : Null", JLabel.LEFT);
		lblVersion.setBackground(Color.BLACK);
		lblVersion.setForeground(Color.RED);
		lblVersion.setFont(new Font("Impact", Font.BOLD, 14));
		
		this.add(lblName, BorderLayout.NORTH);
		this.add(lblValue, BorderLayout.CENTER);
		this.add(lblVersion, BorderLayout.SOUTH);
	}
	
	public void setValue(int number) {
		value = number;
		lblValue.setText(String.valueOf(number + "  "));
	}
	
	public void setVersion(long number) {
		version = number;
		lblVersion.setText("  Version : " + String.valueOf(number));
	}
	
	public int getValue(){
		return value;
	}
	
	public long getVersion(){
		return version;
	}

}
