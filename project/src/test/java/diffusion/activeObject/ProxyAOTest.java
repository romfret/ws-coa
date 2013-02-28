package diffusion.activeObject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diffusion.display.Display;
import diffusion.sensor.Sensor;

public class ProxyAOTest {

	private IProxyAO proxyAO;
	
	@Before
	public void setUp() throws Exception {
		proxyAO = new ProxyAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test if the Update Object is created
	 */
	@Test
	public void testCreateUpdateObject() {
		Future<?> f = proxyAO.createUpdateObject(new Sensor(), new Display("A"));
		assertNotNull("testCreateUpdateObject",f);
	}

	/**
	 * test if invokeAll return a non-null object
	 */
	@Test
	public void testInvokeAll() {
		Future<?> f = proxyAO.createUpdateObject(new Sensor(), new Display("A"));
		List<Future<?>> tasks = new ArrayList<Future<?>>();
		tasks.add(f);
		try {
			assertNotNull("testInvokeAll",proxyAO.invokeAll(tasks));
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
	}

}
