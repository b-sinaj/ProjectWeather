package model;

import jakarta.persistence.*;

import java.util.Date;
import lombok.*;

@Entity
@Table (name = "weathers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

}
