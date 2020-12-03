package com.skd.travel2way.service;

import com.skd.travel2way.domain.*;

import java.util.List;

public interface ITravelLocationService {

    public ResponseDTO searchLocation(String name);

    public String saveLocation(LocationDTO locationDTO);

    public String deleteLocation(int id);

    public List<Place> getAllPlaces(int id);


}
