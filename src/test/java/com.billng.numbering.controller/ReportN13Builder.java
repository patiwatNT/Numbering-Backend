package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN13Dto;

import java.util.Collections;
import java.util.List;

public class ReportN13Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN13Dto getDto() {
        ReportN13Dto dto = new ReportN13Dto();
        dto.setId("1");
        return dto;
    }
}
