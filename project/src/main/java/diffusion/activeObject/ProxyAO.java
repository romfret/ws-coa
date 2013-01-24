package diffusion.activeObject;

import java.util.List;
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
		//(Future<?>)
//		ExecutorService executor = Executors.newSingleThreadExecutor();
		return executor.submit(update);
	}
	
	public List<Future<Object>> invokeAll(List<IUpdate> tasks) throws InterruptedException {
		return executor.invokeAll(tasks);
	}
}
