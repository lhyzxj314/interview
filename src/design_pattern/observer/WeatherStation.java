package design_pattern.observer;

public class WeatherStation {

	public static void main(String[] args) {
		Subject weatherData = new WeatherData();
		
		DisplayElem tempDisplay = new TempDisplay(weatherData);
		DisplayElem HumidityDisplay = new HumidityDisplay(weatherData);
		
		weatherData.setState(10f, 2f, 11);
		weatherData.setState(21f, 22, 80);
	}

}
