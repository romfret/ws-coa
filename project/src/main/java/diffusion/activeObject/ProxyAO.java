package diffusion.activeObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import diffusion.display.IDisplay;
import diffusion.sensor.ISensor;

public class ProxyAO implements IProxyAO {
	
	private ExecutorService executor;
	public ProxyAO() {
		executor = Executors.newFixedThreadPool(10);
	}

	public Future<?> createUpdateObject(ISensor sensor, IDisplay display) {
		IUpdate update = new Update();
		update.setName("ProxyAO update instance");
		
		update.setSubject(sensor);
		update.setObserver(display);

//		ExecutorService executor = Executors.newSingleThreadExecutor();
		return (Future<?>) executor.submit(update);
	}
	
	public void executorShutdown() {
		executor.shutdown();
	}
}
