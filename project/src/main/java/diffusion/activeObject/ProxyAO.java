package diffusion.activeObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class ProxyAO implements IProxyAO {
	
	public Future update(ISensor subject, IDisplay display){
		IUpdate update = new Update();
		update.setName("ProxyAO update instance");
		update.setSubject(subject);
		update.setObserver(display);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		return (Future) executor.submit(update);
	}
}
