package model;

import com.google.gson.annotations.SerializedName;

public class CurrentResponse {

    private float temperature;
    @SerializedName("wind_speed")
    private int windSpeed;
    @SerializedName("wind_dir")
    private String windDir;

    public CurrentResponse() {
    }

    public CurrentResponse(float temperature, int windSpeed, String windDir) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDir = windDir;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    @Override
    public String toString() {
        return "CurrentResponse{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDir=" + windDir +
                '}';
    }
}
