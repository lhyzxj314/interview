package design_pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> list = new ArrayList<Observer>();
	private float temp;
	private float humidity;
	private float pressure;
	
	@Override
	public void registerObsever(Observer obj) {
		list.add(obj);
	}

	@Override
	public void removeObserver(Observer obj) {
		list.remove(obj);
	}

	@Override
	public void notifyObserver() {
		Iterator<Observer> it = list.iterator();
		while(it.hasNext()) {
			Observer obj = it.next();
			obj.update(temp, humidity, pressure);
		}
	}

	@Override
	public float getTemp() {
		return temp;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

	@Override
	public void setState(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObserver();
	}

}
