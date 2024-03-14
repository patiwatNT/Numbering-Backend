package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedRangeDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class AssignedRangeBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static AssignedRangeDto getDto() {
        AssignedRangeDto dto = new AssignedRangeDto();
        dto.setNo(BigDecimal.valueOf(1));
        return dto;
    }
}
