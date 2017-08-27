package design_pattern.observer;

public class TempDisplay implements Observer, DisplayElem {
	private Subject weatherData;
	private float temp;
	
	public TempDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObsever(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		display();
	}
	
	@Override
	public void display() {
		System.out.println("Temp Display:" + this.temp);
	}

}
