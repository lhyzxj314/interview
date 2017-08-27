package design_pattern.observer;


public interface Subject {
	public void registerObsever(Observer obj);
	public void removeObserver(Observer obj);
	public void notifyObserver();
	
	public float getTemp();
	public float getPressure();
	public float getHumidity();
	public void setState(float temp, float humidity, float pressure);
}
