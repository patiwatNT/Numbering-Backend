package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Dto;

import java.util.Collections;
import java.util.List;

public class ReportN16Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN16Dto getDto() {
        ReportN16Dto dto = new ReportN16Dto();
        dto.setId("1");
        return dto;
    }
}
