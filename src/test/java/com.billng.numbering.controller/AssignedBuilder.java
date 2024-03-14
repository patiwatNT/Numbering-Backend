package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class AssignedBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static AssignedDto getDto() {
        AssignedDto dto = new AssignedDto();
        dto.setNo(BigDecimal.valueOf(1));
        return dto;
    }
}
