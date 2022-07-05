package com.uday.mbs.entities;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    @Column(length = 20, nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<Theatre> theatres;

    public City() {}

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setSingleTheatre(Theatre theatre){ this.theatres.add(theatre);}

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", cityName='" + cityName + '\'' + '}';
    }
}
