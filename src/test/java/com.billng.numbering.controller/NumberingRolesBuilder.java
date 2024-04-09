package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingRolesDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class NumberingRolesBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingRolesDto getDto() {
        NumberingRolesDto dto = new NumberingRolesDto();
        dto.setRoleId(BigDecimal.valueOf(1));
        System.out.println("Role Name : "+dto.getRoleName());
        return dto;
    }
}
