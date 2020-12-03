package com.skd.travel2way.domain;

import javax.persistence.Column;
import java.io.Serializable;

public interface Place {

    Integer getPlaceId();
    String getPlaceName();
    String getCountry();
    String getState() ;
    String getPlaceDesc();
    String getPlaceReview();
    String getPlaceRating();

}
