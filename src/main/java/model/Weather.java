package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "date_from")
    private Date dateFrom;
    @Column(name ="direction")
    private int direction;
    @Column(name ="humidity")
    private  int humidity;
    @Column(name ="pressure")
    private int pressure;
    @Column(name ="speed")
    private double speed;
    @Column(name ="temperature")
    private double temperature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", dateFrom=" + dateFrom +
                ", direction=" + direction +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", speed=" + speed +
                ", temperature=" + temperature +
                '}';
    }
}
