package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrRolesDto;

import java.util.Collections;
import java.util.List;

public class NbrRolesBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NbrRolesDto getDto() {
        NbrRolesDto dto = new NbrRolesDto();
        dto.setRoleId(1);
        return dto;
    }
}
