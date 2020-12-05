package com.skd.travel2way.service.impl;

import com.skd.travel2way.config.GeneratePdfReport;
import com.skd.travel2way.domain.*;
import com.skd.travel2way.repo.TravelLocationRepo;
import com.skd.travel2way.service.ITravelLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class TravelLocationServiceImpl implements ITravelLocationService {


    @Autowired
    private TravelLocationRepo travelLocationRepo;

    @Autowired
    private GeneratePdfReport generatePdfReport;

    @Override

    @Cacheable(value = "locationCache", key = "#name")
    public ResponseDTO searchLocation(String name) {
        ResponseDTO response= new ResponseDTO();
        LocationDTO locationDTO= new LocationDTO();
        locationDTO.setLocations(travelLocationRepo.findByLocationName(name));
        response.setResponse(locationDTO);
        return response;

    }

    @Override
    @Cacheable(value = "locationCache", key = "#name")
    public ResponseDTO searchLocationAuto(String name) {
        ResponseDTO response= new ResponseDTO();
        LocationDTO locationDTO= new LocationDTO();
        locationDTO.setLocations(travelLocationRepo.findByLocationNameContainingIgnoreCase(name));
        response.setResponse(locationDTO);
        return response;
    }

    @Override
    public ResponseDTO allLocation() {
        ResponseDTO response= new ResponseDTO();
        LocationDTO locationDTO= new LocationDTO();
        locationDTO.setLocations(travelLocationRepo.findAll());
        response.setResponse(locationDTO);
        return response;
    }

    @Override
    public ResponseDTO findByCountry(String country) {
        ResponseDTO response= new ResponseDTO();
        LocationDTO locationDTO= new LocationDTO();
        locationDTO.setLocations(travelLocationRepo.findByPlaces_Country(country));
        response.setResponse(locationDTO);
        return response;
    }

    @Override
    public void updateLocationDesc(String locationDesc, int locationId) {
        travelLocationRepo.updateSome(locationDesc,locationId);
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

    @Override
    public ByteArrayInputStream getPdf(String Location) {
        ResponseDTO response=searchLocation(Location);
        return generatePdfReport.LocationReport(response.getResponse().getLocations());
    }


}
