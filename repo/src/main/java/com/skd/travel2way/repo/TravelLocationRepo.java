package com.skd.travel2way.repo;

import com.skd.travel2way.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TravelLocationRepo extends JpaRepository<Location,Integer> {

    public List<Location> findByLocationName(String locationName);

    @Query(value = "select tp.PLACE_ID as placeId ,tp.PLACE_NAME as placeName ,tp.PLACE_COUNTRY as country,tp.PLACE_STATE as state,tp.PLACE_DESC as placeDesc ,tp.PLACE_REVIEW as placeReview,tp.PLACE_RATING as placeRating from travel_places tp where tp.LOCATION_ID = 17",nativeQuery = true)
    public List<Place> retrivebyLocationId(@Param("locationId") int locationId);

    List<Location> findByLocationNameContainingIgnoreCase(String locationName);

    List<Location> findByPlaces_Country(String country);

    @Modifying
    @Transactional
    @Query("update Location loc  set loc.locationDesc = :locationDesc where loc.locationId = :locationId")
    void updateSome(@Param("locationDesc") String description, @Param("locationId") int locationId);




}
