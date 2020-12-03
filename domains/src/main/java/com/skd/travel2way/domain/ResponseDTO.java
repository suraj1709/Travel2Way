package com.skd.travel2way.domain;


import java.io.Serializable;

public class ResponseDTO  implements Serializable {

    private LocationDTO response;

    public LocationDTO getResponse() {
        return response;
    }

    public void setResponse(LocationDTO response) {
        this.response = response;
    }
}
