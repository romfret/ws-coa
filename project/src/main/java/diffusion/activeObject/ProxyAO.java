package diffusion.activeObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import diffusion.sensor.strategy.IDiffusion;

public class ProxyAO implements IProxyAO {

	public Future update(IDiffusion diffusion) {
		IUpdate update = new Update();
		update.setName("ProxyAO update instance");
		update.setSubject(diffusion);
		
		update.setObserver(display);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		return (Future) executor.submit(update);
	}
}
