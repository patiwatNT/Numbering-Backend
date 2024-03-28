package com.billng.numbering.controller;

import com.billng.numbering.dto.ServiceCenterDto;

import java.util.Collections;
import java.util.List;

public class ServiceCenterBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ServiceCenterDto getDto() {
        ServiceCenterDto dto = new ServiceCenterDto();
        dto.setId("1");
        return dto;
    }
}
