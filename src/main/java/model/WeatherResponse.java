package model;

public class WeatherResponse {

    CurrentResponse current = new CurrentResponse();

    public WeatherResponse() {
    }

    public WeatherResponse(CurrentResponse current) {
        this.current = current;
    }

    public CurrentResponse getCurrent() {
        return current;
    }

    public void setCurrent(CurrentResponse current) {
        this.current = current;
    }
}
