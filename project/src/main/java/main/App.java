package main;


import gui.GlobalGUI;
import gui.command.CommandAddDisplay;
import gui.command.CommandDiffusion;
import gui.command.CommandRemoveDisplay;

import java.util.HashMap;
import java.util.Map;

import utils.Clock;
import diffusion.channel.proxy.Channel;
import diffusion.channel.proxy.IChannel;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;
import diffusion.sensor.Sensor;

/**
 * 
 * @author Douchement & Le Ho
 *
 */
public class App {
	
	public static final int ATOMIC_DIFFUSION = 0;
	public static final int SEQUENTIAL_DIFFUSION = 1;
	public static final int PERIOD_DIFFUSION = 2;
	
	private static GlobalGUI gui;
	private static ISensor sensor;
	private static Map<String, IDisplay> displays;
	private static Map<String, IChannel> channels;
	
	public static void main(String[] args) {
		// Instanciation of an gui, a sensors, displays and channels
		gui = new GlobalGUI();
		sensor = new Sensor();
		displays = new HashMap<String, IDisplay>();
		channels = new HashMap<String, IChannel>();
		
		// Instanciation of a new clock which will tick every second
		Clock h = new Clock();
		h.periodicallyActivate(sensor, 1000);
		
		// Set the command for the gui interaction
		gui.setCommandDiffusion(new CommandDiffusion(sensor));
		gui.setCommandAddDisplay(new CommandAddDisplay());
		gui.setCommandRemoveDisplay(new CommandRemoveDisplay());
		
		// Add 3 displays by default
		addDisplay();
		addDisplay();
		addDisplay();
	}
	
	/**
	 * Add a new display in the app and presentation
	 */
	public static void addDisplay() {
		int number = displays.size() + 1;
		
		IDisplay display = new Display("Display_" + number);
		IChannel channel = new Channel("Channel_" + number, display);
		
		sensor.attach(channel);
		gui.addDisplay(display.getPresentation());
		
		displays.put(display.getName(), display);
		channels.put(channel.getName(), channel);
	}
	
	/**
	 * remove a display from the app and presentation
	 */
	public static void removeDisplay() {
		int number = displays.size();
		
		if (number > 0) {
			IDisplay display = displays.get("Display_" + number);
			IChannel channel = channels.get("Channel_" + number);
			
			gui.removeDisplay(display.getPresentation());
			sensor.detach(channel);
			
			displays.remove(display.getName());
			channels.remove(channel.getName());
		}
	}
}
