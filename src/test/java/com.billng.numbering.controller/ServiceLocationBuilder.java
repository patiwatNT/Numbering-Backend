package com.billng.numbering.controller;

import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.entities.ServiceLocationPK;

import java.util.Collections;
import java.util.List;

public class ServiceLocationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ServiceLocationDto getDto() {
        ServiceLocationDto dto = new ServiceLocationDto();
        ServiceLocationPK pk = new ServiceLocationPK();
        dto.setServiceLocationPK(pk);
        //dto.setId("1");
        return dto;
    }
}
