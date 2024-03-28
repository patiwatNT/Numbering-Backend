package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN11Dto;

import java.util.Collections;
import java.util.List;

public class ReportN11Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN11Dto getDto() {
        ReportN11Dto dto = new ReportN11Dto();
        dto.setId("1");
        return dto;
    }
}
