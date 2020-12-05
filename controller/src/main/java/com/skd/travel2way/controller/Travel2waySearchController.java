package com.skd.travel2way.controller;

import com.skd.travel2way.domain.Place;
import com.skd.travel2way.domain.ResponseDTO;
import com.skd.travel2way.service.ITravelLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/travel/way")
@Tag(name="Travel Search API",description = "Travel for different location API")
public class Travel2waySearchController {
    @Autowired
    private ITravelLocationService iTravelLocationService;

    @Operation(description = "Get all Location")
    @GetMapping("/searchLocation")
    public ResponseDTO searchLocation(@RequestParam(value ="location" ) String location)
    {
        return iTravelLocationService.searchLocation(location);
    }

    @Operation(description = "Get all Places")
    @GetMapping("/searchPlaces")
    public List<Place> searchPlcaes(@RequestParam(value ="locationId" ) int locationId)
    {
        return iTravelLocationService.getAllPlaces(locationId);
    }

    @Operation(description = "Search All Location")
    @PostMapping("/searchAllLocation")
    public ResponseDTO searchAllLocation()
    {
        return iTravelLocationService.allLocation();
    }

    @Operation(description = "Get all Location")
    @GetMapping("/searchLocationAuto")
    public ResponseDTO searchLocationAuto(@RequestParam(value ="location" ) String location)
    {
        return iTravelLocationService.searchLocationAuto(location);
    }

    @Operation(description = "Get all Location")
    @GetMapping("/searchByCountry")
    public ResponseDTO searchByCountry(@RequestParam(value ="country" ) String country)
    {
        return iTravelLocationService.findByCountry(country);
    }

}
