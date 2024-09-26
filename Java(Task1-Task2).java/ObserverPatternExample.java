import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature, float humidity, float pressure);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature, humidity, pressure;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

class MobileApp implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Mobile App - Temp: " + temperature + " Humidity: " + humidity + " Pressure: " + pressure);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileApp mobileApp = new MobileApp();

        station.addObserver(mobileApp);
        station.setMeasurements(25.3f, 65.4f, 1013.1f);
    }
}
