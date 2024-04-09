package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingPrivilegesDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class NumberingPrivilegesBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingPrivilegesDto getDto() {
        NumberingPrivilegesDto dto = new NumberingPrivilegesDto();
        dto.setPrivilegeId(BigInteger.valueOf(1));
        return dto;
    }
}
