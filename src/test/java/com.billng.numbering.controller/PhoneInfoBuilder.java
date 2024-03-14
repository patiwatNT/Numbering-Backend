package com.billng.numbering.controller;

import com.billng.numbering.dto.PhoneInfoDto;

import java.util.Collections;
import java.util.List;

public class PhoneInfoBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static PhoneInfoDto getDto() {
        PhoneInfoDto dto = new PhoneInfoDto();
        dto.setPhone("1");
        return dto;
    }
}
