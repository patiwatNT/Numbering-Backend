package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingDataExportDto;

import java.util.Collections;
import java.util.List;

public class NumberingDataExportBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingDataExportDto getDto() {
        NumberingDataExportDto dto = new NumberingDataExportDto();
        dto.setId("1");
        return dto;
    }
}
