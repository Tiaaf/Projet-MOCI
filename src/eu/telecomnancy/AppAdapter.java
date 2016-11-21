package eu.telecomnancy;

import eu.telecomnancy.helpers.LegacyTemperatureSensorAdapter;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;

public class AppAdapter {
	   public static void main(String[] args) {
	        LegacyTemperatureSensor sensor = new LegacyTemperatureSensor();
	        LegacyTemperatureSensorAdapter adapter = new LegacyTemperatureSensorAdapter(sensor);
	        new ConsoleUI(adapter);
	    }
}
