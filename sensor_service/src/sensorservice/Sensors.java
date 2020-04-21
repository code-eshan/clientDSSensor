package sensorservice;

import java.util.ArrayList;
import java.util.List;

public class Sensors {

	private static ArrayList<Sensor> sensors = new ArrayList<>();
	
	static {
		sensors.add(new Sensor(1,1,100,5,7));
		sensors.add(new Sensor(2,1,101,7,9));
	}
	
	//Get Sensors
	public static List<Sensor> getSensors() {
		return sensors;
	}
	
	//Add a sensor
	public static void addSensor(Sensor sensor) {
		sensors.add(sensor);
	}
	
	//Delete a sensor
	public static boolean deleteSensor(int id) {
		for (Sensor sensor : sensors) {
			if(sensor.getSensorId() == id) {
				sensors.remove(id);
				return true;
			}
		}
		return false;
	}
	
}
