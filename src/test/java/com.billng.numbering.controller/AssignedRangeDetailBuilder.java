package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedRangeDetailDto;
import com.billng.numbering.entities.AssignedRangeDetailPK;

import java.util.Collections;
import java.util.List;

public class AssignedRangeDetailBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static AssignedRangeDetailDto getDto() {
        AssignedRangeDetailDto dto = new AssignedRangeDetailDto();
        AssignedRangeDetailPK pk = new AssignedRangeDetailPK();
        dto.setAssignedRangeDetailPK(pk);
        //dto.setId("1");
        return dto;
    }
}
