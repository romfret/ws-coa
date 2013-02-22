package diffusion.display.ihm;

import diffusion.sensor.ISensor;


public interface IIhm {

	void addDisplay(DisplayGUI displayGUI);

	void setSensor(ISensor sensor);

}
