package eu.telecomnancy.helpers;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class LegacyTemperatureSensorAdapter implements ISensor{
	
	private LegacyTemperatureSensor sensor;
	
	public LegacyTemperatureSensorAdapter(LegacyTemperatureSensor sensor)
	{
		this.sensor = sensor;
	}
	
	public void on() 
	{
		if (!sensor.getStatus())
			sensor.onOff();
	}

	public void off() 
	{
		if (sensor.getStatus())
			sensor.onOff();
	}

	public boolean getStatus() 
	{
		return sensor.getStatus();
	}

	public void update() throws SensorNotActivatedException 
	{
		if (this.getStatus())
		{
			this.off();
			this.on();
		}
		else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	public double getValue() throws SensorNotActivatedException 
	{
		if (this.getStatus())
			return sensor.getTemperature();
		 else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}
	
	
}
