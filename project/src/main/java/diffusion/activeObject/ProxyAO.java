package diffusion.activeObject;

import diffusion.observer.ISubject;

public class ProxyAO implements IProxyAO {
	
	public Future update(ISubject subject){
		IUpdate update = new Update();
		update.setObserver();
		
	}

}
