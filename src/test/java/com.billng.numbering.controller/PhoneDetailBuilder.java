package com.billng.numbering.controller;

import com.billng.numbering.dto.PhoneDetailDto;
import com.billng.numbering.entities.PhoneDetailPK;

import java.util.Collections;
import java.util.List;

public class PhoneDetailBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static PhoneDetailDto getDto() {
        PhoneDetailDto dto = new PhoneDetailDto();
        PhoneDetailPK pk = new PhoneDetailPK();
        dto.setPhoneDetailPK(pk);
        //dto.setId("1");
        return dto;
    }
}
