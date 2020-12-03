package com.skd.travel2way.service;

import com.skd.travel2way.domain.*;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ITravelLocationService {

     ResponseDTO searchLocation(String name);

     String saveLocation(LocationDTO locationDTO);

     String deleteLocation(int id);

     List<Place> getAllPlaces(int id);

     ByteArrayInputStream getPdf(String Location);


}
