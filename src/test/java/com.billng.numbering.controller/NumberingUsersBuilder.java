package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingUsersDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class NumberingUsersBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static NumberingUsersDto getDto() {
        NumberingUsersDto dto = new NumberingUsersDto();
        dto.setUserId(BigDecimal.valueOf(1));
        return dto;
    }
}
