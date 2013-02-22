package diffusion.activeObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
		return executor.submit(update);
	}
	
	public List<Future<Object>> invokeAll(List<Future<?>> tasks) throws InterruptedException {
		List<IUpdate> u = new ArrayList<IUpdate>();
		for (Future<?> task : tasks) {
			try {
				System.out.println("futur");
				@SuppressWarnings("unchecked")
				Future<Object> future = (Future<Object>) ((Future<?>) task).get();
				System.out.println("future"+future.get());
//				u.add((IUpdate) future.get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return executor.invokeAll(u);
	}
}
