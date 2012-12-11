package diffusion.activeObject;

import diffusion.observer.ISubject;

public interface IProxyAO {

	public abstract Future update(ISubject s);

}