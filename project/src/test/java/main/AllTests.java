package main;
import gui.DisplayGUITest;
import gui.GlobalGUITest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import diffusion.activeObject.ProxyAOTest;
import diffusion.activeObject.UpdateTest;
import diffusion.display.DisplayTest;
import diffusion.sensor.SensorTest;
import diffusion.sensor.strategy.AtomicDiffusionIntegrationTest;
import diffusion.sensor.strategy.SequentialDiffusionIntegrationTest;


@RunWith(Suite.class)
@SuiteClasses({
	ProxyAOTest.class, 
	UpdateTest.class, 
	DisplayGUITest.class,
	GlobalGUITest.class,
	DisplayTest.class,
	AtomicDiffusionIntegrationTest.class,
	SequentialDiffusionIntegrationTest.class,
	SensorTest.class
})
public class AllTests {

}
