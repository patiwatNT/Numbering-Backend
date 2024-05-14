package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrServiceNumbersDto;

import java.util.Collections;
import java.util.List;

public class NbrServiceNumbersBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NbrServiceNumbersDto getDto() {
        NbrServiceNumbersDto dto = new NbrServiceNumbersDto();
        dto.setServiceNo("1");
        return dto;
    }
}
