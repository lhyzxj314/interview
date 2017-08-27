package design_pattern.observer;

public class HumidityDisplay implements Observer, DisplayElem {
	private Subject weatherData;
	private float humidity;
	
	public HumidityDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObsever(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("HumidityDisplay:" + this.humidity);
	}
}
