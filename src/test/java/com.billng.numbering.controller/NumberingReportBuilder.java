package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingReportDto;

import java.util.Collections;
import java.util.List;

public class NumberingReportBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingReportDto getDto() {
        NumberingReportDto dto = new NumberingReportDto();
        dto.setNo("1");
        return dto;
    }
}
