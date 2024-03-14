package com.billng.numbering.controller;

import com.billng.numbering.dto.DivisionDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class DivisionBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static DivisionDto getDto() {
        DivisionDto dto = new DivisionDto();
        dto.setId(BigDecimal.valueOf(1));
        return dto;
    }
}
