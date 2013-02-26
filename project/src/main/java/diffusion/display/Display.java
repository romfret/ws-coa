package diffusion.display;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import diffusion.activeObject.IUpdate;
import diffusion.display.ihm.DisplayGUI;
import diffusion.sensor.ISensor;

/**
 * @author taira
 *
 */
public class Display implements IDisplay {
	
	private String name;
	private int value;
	public long version;
	
	private DisplayGUI displayGUI;

	public Display(String name) {
		this.name = name;
		displayGUI = new DisplayGUI(name);
	}

	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#update(diffusion.sensor.ISensor)
	 */
	public Future<Object> update(ISensor s) {
		long newVersion = s.getVersion();
		
		// Epoque verification
		if (newVersion > version) {
			value = s.getValue();
			version = s.getVersion();
	
			System.err.println(this);
			displayGUI.setValue(value);
			displayGUI.setVersion(version);
		}
		
		Future<Object> f = new Future<Object>() {
			public String toString() {
				return "TROLOLOLO dans un Future factice renvoyé par Display.update(..)";
			}

			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			public boolean isCancelled() {
				return false;
			}

			public boolean isDone() {
				return false;
			}

			public Object get() throws InterruptedException, ExecutionException {
				return null;
			}

			public Object get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				return null;
			}
		};
		
		return f;
	}

	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#getValue()
	 */
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		String valueStr = "";
		if (value < 10)
			valueStr = " " + Integer.toString(value);
		else
			valueStr = Integer.toString(value);
		
		return "[" + name + "] - [Sensor Value = " + valueStr + "] - [Version : " + version + "]";
	}

	public DisplayGUI getPresentation() {
		return displayGUI;
	}


	/* (non-Javadoc)
	 * @see diffusion.display.IDisplay#createUpdate(diffusion.sensor.ISensor)
	 */
	public IUpdate createUpdate(ISensor sensor) {
		return null;
	}

	
}
