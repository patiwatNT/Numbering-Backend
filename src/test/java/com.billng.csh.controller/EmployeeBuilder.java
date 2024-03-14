package com.billng.numbering.controller;

import com.billng.numbering.dto.EmployeeDto;

import java.util.Collections;
import java.util.List;

public class EmployeeBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static EmployeeDto getDto() {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(1);
        return dto;
    }
}
