package com.billng.numbering.controller;

import com.billng.numbering.dto.BlockDetailDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class BlockDetailBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static BlockDetailDto getDto() {
        BlockDetailDto dto = new BlockDetailDto();
        dto.setNo(BigDecimal.valueOf(1));
        return dto;
    }
}
