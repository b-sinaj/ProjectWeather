package model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="locations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @Column(name ="city")
    private String city;
    @Column(name ="country")
    private String country;
    @Column(name ="latitude")
    private double latitude;
    @Column(name ="longitude")
    private double longitude;
    @Column(name ="region")
    private String region;

}
