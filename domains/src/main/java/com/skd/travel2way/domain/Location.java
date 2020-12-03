package com.skd.travel2way.domain;


import org.hibernate.annotations.GenericGenerators;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema ="Travel2Way",name ="TRAVEL_LOCATION")
public class Location implements Serializable {
    @Id
    @Column(name = "LOCATION_ID")
    private int locationId;
    @Column(name = "LOCATION_NAME")
    private  String locationName;
    @Column(name = "LOCATION_COUNTRY")
    private String country;
    @Column(name = "LOCATION_STATE")
    private String state;
    @Column(name = "LOCATION_DESC")
    private String locationDesc;
    @OneToMany(targetEntity = Places.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_ID",referencedColumnName = "LOCATION_ID")
    private Set<Places> places;


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public Set<Places> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Places> places) {
        this.places = places;
    }
}
