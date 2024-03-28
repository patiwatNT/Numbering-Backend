package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN15Dto;

import java.util.Collections;
import java.util.List;

public class ReportN15Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN15Dto getDto() {
        ReportN15Dto dto = new ReportN15Dto();
        dto.setId("1");
        return dto;
    }
}
