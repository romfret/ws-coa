package diffusion;

import java.util.HashMap;
import java.util.Map;

import utils.Clock;
import diffusion.channel.proxy.Channel;
import diffusion.channel.proxy.IChannel;
import diffusion.display.Display;
import diffusion.display.IDisplay;
import diffusion.display.ihm.Ihm;
import diffusion.display.ihm.command.CommandAddDisplay;
import diffusion.display.ihm.command.CommandDiffusion;
import diffusion.display.ihm.command.CommandRemoveDisplay;
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
	
	private static Ihm ihm;
	private static ISensor sensor;
	private static Map<String, IDisplay> displays;
	private static Map<String, IChannel> channels;
	
	public static void main(String[] args) {
		ihm = new Ihm();
		sensor = new Sensor();
		displays = new HashMap<String, IDisplay>();
		channels = new HashMap<String, IChannel>();
		
		Clock h = new Clock();
		h.periodicallyActivate(sensor, 1000);
		
		ihm.setCommandDiffusion(new CommandDiffusion(sensor));
		ihm.setCommandAddDisplay(new CommandAddDisplay());
		ihm.setCommandRemoveDisplay(new CommandRemoveDisplay());
		
		addDisplay();
		addDisplay();
		addDisplay();
	}
	
	public static void addDisplay() {
		int number = displays.size() + 1;
		
		IDisplay display = new Display("Display_" + number);
		IChannel channel = new Channel("Channel_" + number, display);
		
		sensor.attach(channel);
		ihm.addDisplay(display.getPresentation());
		
		displays.put(display.getName(), display);
		channels.put(channel.getName(), channel);
	}
	
	public static void removeDisplay() {
		int number = displays.size();
		
		if (number > 0) {
			IDisplay display = displays.get("Display_" + number);
			IChannel channel = channels.get("Channel_" + number);
			
			ihm.removeDisplay(display.getPresentation());
			sensor.detach(channel);
			
			displays.remove(display.getName());
			channels.remove(channel.getName());
		}
	}
}
