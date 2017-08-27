package design_pattern.observer;

public class CurrentConditionDisplay implements Observer, DisplayElem {
	private Subject weatherData;
	private float temp;
	private float humidity;
	private float pressure;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObsever(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("temp:" + temp);
		System.out.println("humidity:" + humidity);
		System.out.println("pressure:" + pressure);
	}

}
