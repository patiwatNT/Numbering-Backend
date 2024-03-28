package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN12Dto;

import java.util.Collections;
import java.util.List;

public class ReportN12Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN12Dto getDto() {
        ReportN12Dto dto = new ReportN12Dto();
        dto.setId("1");
        return dto;
    }
}
