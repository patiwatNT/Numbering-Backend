package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block1000Dto;

import java.util.Collections;
import java.util.List;

public class ReportN16Block1000Builder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static ReportN16Block1000Dto getDto() {
        ReportN16Block1000Dto dto = new ReportN16Block1000Dto();
        dto.setId("1");
        return dto;
    }
}
