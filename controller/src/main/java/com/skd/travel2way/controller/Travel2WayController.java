package com.skd.travel2way.controller;


import com.skd.travel2way.domain.LocationDTO;
import com.skd.travel2way.domain.Place;
import com.skd.travel2way.domain.Places;
import com.skd.travel2way.domain.ResponseDTO;
import com.skd.travel2way.service.ITravelLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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



    @Operation(description = "Save Location")
    @PostMapping("/saveLocation")
    public ResponseEntity saveLocation(@RequestBody LocationDTO locationDTO)
    {
        return new ResponseEntity(iTravelLocationService.saveLocation(locationDTO),HttpStatus.CREATED);
    }



    @Operation(description = "Delete Location")
    @DeleteMapping("/delete")
    public ResponseEntity saveLocation(@RequestParam(value = "id") int id)
    {

        return new ResponseEntity(iTravelLocationService.deleteLocation(id), HttpStatus.OK);
    }



    @Operation(description = "Generate PDF File")
    @GetMapping(name = "/getpdffile",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> searchPlcaes(@RequestParam(value ="location" ) String location)
    {
        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=location.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(iTravelLocationService.getPdf(location)));

    }


    @Operation(description = "Get all Location")
    @PutMapping("/updateLocationDesc")
    public ResponseEntity updateLocationDesc(@RequestParam(value ="locationDesc" ) String locationDesc,@RequestParam(value = "locationId") int locationId)
    {
        iTravelLocationService.updateLocationDesc(locationDesc,locationId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
