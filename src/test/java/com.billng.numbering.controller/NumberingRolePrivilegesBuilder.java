package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.entities.NumberingRolePrivilegesPK;

import java.util.Collections;
import java.util.List;

public class NumberingRolePrivilegesBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingRolePrivilegesDto getDto() {
        NumberingRolePrivilegesDto dto = new NumberingRolePrivilegesDto();
        NumberingRolePrivilegesPK pk = new NumberingRolePrivilegesPK();
        dto.setNumberingRolePrivilegesPK(pk);
        return dto;
    }
}
