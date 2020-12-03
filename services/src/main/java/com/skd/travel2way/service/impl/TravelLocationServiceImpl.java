package com.skd.travel2way.service.impl;

import com.skd.travel2way.domain.*;
import com.skd.travel2way.repo.TravelLocationRepo;
import com.skd.travel2way.service.ITravelLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class TravelLocationServiceImpl implements ITravelLocationService {


    @Autowired
    private TravelLocationRepo travelLocationRepo;



    @Override
    public ResponseDTO searchLocation(String name) {
        ResponseDTO response= new ResponseDTO();
        LocationDTO locationDTO= new LocationDTO();
        locationDTO.setLocations(travelLocationRepo.findByLocationName(name));
        response.setResponse(locationDTO);
        return response;

    }

    @Override
    public String saveLocation(LocationDTO locationDTO) {
        if(locationDTO!=null && locationDTO.getLocations()!=null && locationDTO.getLocations().size()!=0 ) {
            for(Location loc:locationDTO.getLocations())
            {
                if(loc!=null && travelLocationRepo.existsById(loc.getLocationId()))
                {
                    Location loca=travelLocationRepo.getOne(loc.getLocationId());
                    Set<Places> places=loca.getPlaces();
                    places.addAll(loc.getPlaces());
                    loca.setPlaces(places);
                    travelLocationRepo.save(loca);
                }
                else
                {
                    travelLocationRepo.save(loc);
                }

            }
         return "Saved";
        }
        return "Failed to save";

    }

    @Override
    public String deleteLocation(int id) {
        if(travelLocationRepo.existsById(id))
        {
            travelLocationRepo.deleteById(id);
            return "Deleted";
        }
        return "No id present";
    }

    @Override
    public List<Place> getAllPlaces(int id) {
        return travelLocationRepo.retrivebyLocationId(id);

    }


}
