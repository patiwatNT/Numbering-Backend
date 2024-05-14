package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrUsersRolesDto;

import java.util.Collections;
import java.util.List;

public class NbrUsersRolesBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NbrUsersRolesDto getDto() {
        NbrUsersRolesDto dto = new NbrUsersRolesDto();
        dto.setEmpId("1");
        return dto;
    }
}
