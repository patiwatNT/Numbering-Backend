package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block500OnlyDto;

import java.util.Collections;
import java.util.List;

public class ReportN16Block500OnlyBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN16Block500OnlyDto getDto() {
        ReportN16Block500OnlyDto dto = new ReportN16Block500OnlyDto();
        dto.setId("1");
        return dto;
    }
}
