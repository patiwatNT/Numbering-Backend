package com.billng.numbering.controller;

import com.billng.numbering.dto.BlockDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class BlockBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static BlockDto getDto() {
        BlockDto dto = new BlockDto();
        dto.setBlockId(BigDecimal.valueOf(1));
        return dto;
    }
}
