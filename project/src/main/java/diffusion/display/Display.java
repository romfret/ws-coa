package diffusion.display;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import diffusion.activeObject.IUpdate;
import diffusion.display.ihm.DisplayGUI;
import diffusion.sensor.ISensor;

public class Display implements IDisplay {
	
	private String name;
	private int value;
	public long version;
	
	private DisplayGUI displayGUI;

	public Display(String name) {
		this.name = name;
		displayGUI = new DisplayGUI(name);
	}

	public Future<Object> update(ISensor s) {
		long newVersion = s.getVersion();
		
		// Epoque test
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
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isCancelled() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isDone() {
				// TODO Auto-generated method stub
				return false;
			}

			public Object get() throws InterruptedException, ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}

			public Object get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		return f;
	}

	public String getName() {
		return name;
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


	public IUpdate createUpdate(ISensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
