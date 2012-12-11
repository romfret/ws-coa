package diffusion.activeObject;

import diffusion.observer.Subject;

public interface IProxyAO {

	public abstract Future update(Subject s);

}