package com.billng.numbering.controller;

import com.billng.numbering.dto.ConfigCodeDto;

import java.util.Collections;
import java.util.List;

public class ConfigCodeBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ConfigCodeDto getDto() {
        ConfigCodeDto dto = new ConfigCodeDto();
        dto.setId("1");
        return dto;
    }
}
