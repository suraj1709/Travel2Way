package com.skd.travel2way.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema ="Travel2Way",name ="travel_places")
public class Places implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLACE_ID")
    private int placeId;
    @Column(name = "PLACE_NAME")
    private String placeName;
    @Column(name = "PLACE_COUNTRY")
    private String country;
    @Column(name = "PLACE_STATE")
    private String state;
    @Column(name = "PLACE_DESC")
    private String placeDesc;
    @Column(name = "PLACE_REVIEW")
    private String placeReview;
    @Column(name = "PLACE_RATING")
    private String placeRating;
    @Column(name = "LOCATION_ID")
    private int locationId;

    private Location location;


    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
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

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public String getPlaceReview() {
        return placeReview;
    }

    public void setPlaceReview(String placeReview) {
        this.placeReview = placeReview;
    }

    public String getPlaceRating() {
        return placeRating;
    }

    public void setPlaceRating(String placeRating) {
        this.placeRating = placeRating;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Places(int placeId, String placeName, String country, String state, String placeDesc, String placeReview, String placeRating) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.country = country;
        this.state = state;
        this.placeDesc = placeDesc;
        this.placeReview = placeReview;
        this.placeRating = placeRating;
    }
}


