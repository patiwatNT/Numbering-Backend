package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block500IncDto;

import java.util.Collections;
import java.util.List;

public class ReportN16Block500IncBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN16Block500IncDto getDto() {
        ReportN16Block500IncDto dto = new ReportN16Block500IncDto();
        dto.setId("1");
        return dto;
    }
}
