package com.skd.travel2way.controller;


import com.skd.travel2way.domain.LocationDTO;
import com.skd.travel2way.domain.Place;
import com.skd.travel2way.domain.Places;
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
@Tag(name="Travel API",description = "Travel for different location API")
public class Travel2WayController
{

    @Autowired
    private ITravelLocationService iTravelLocationService;


    @Operation(description = "Get all Location")
    @GetMapping("/searchLocation")
    public ResponseDTO searchLocation(@RequestParam(value ="location" ) String location)
    {
        return iTravelLocationService.searchLocation(location);
    }

    @Operation(description = "Save Location")
    @PostMapping("/saveLocation")
    public String saveLocation(@RequestBody LocationDTO locationDTO)
    {
        return iTravelLocationService.saveLocation(locationDTO);
    }

    @Operation(description = "Delete Location")
    @GetMapping("/delete")
    public String saveLocation(@RequestParam(value = "id") int id)
    {
        return iTravelLocationService.deleteLocation(id);
    }

    @Operation(description = "Get all Places")
    @GetMapping("/searchPlaces")
    public List<Place> searchPlcaes(@RequestParam(value ="locationId" ) int locationId)
    {
        return iTravelLocationService.getAllPlaces(locationId);
    }

}
