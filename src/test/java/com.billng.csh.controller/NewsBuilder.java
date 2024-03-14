package com.billng.numbering.controller;

import com.billng.numbering.dto.NewsDto;

import java.util.Collections;
import java.util.List;

public class NewsBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NewsDto getDto() {
        NewsDto dto = new NewsDto();
        dto.setId("1");
        return dto;
    }
}
