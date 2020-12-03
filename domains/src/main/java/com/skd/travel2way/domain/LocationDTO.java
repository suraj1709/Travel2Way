package com.skd.travel2way.domain;




import java.io.Serializable;
import java.util.List;

public class LocationDTO implements Serializable {

    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
