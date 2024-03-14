package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingLocationDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class NumberingLocationBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingLocationDto getDto() {
        NumberingLocationDto dto = new NumberingLocationDto();
        dto.setId(BigDecimal.valueOf(1));
        return dto;
    }
}
