package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block100OnlyDto;

import java.util.Collections;
import java.util.List;

public class ReportN16Block100OnlyBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN16Block100OnlyDto getDto() {
        ReportN16Block100OnlyDto dto = new ReportN16Block100OnlyDto();
        dto.setId("1");
        return dto;
    }
}
