package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrServiceNumbersDto;

import java.util.List;

public interface NbrServiceNumbersRepositoryCustom {
    NbrServiceNumbersDto findByServiceNumber(String serviceNumber);
    List<NbrServiceNumbersDto> findByAssignedId(int assignedId);

    void updateServiceLocation(NbrServiceNumbersDto nbrServiceNumbersDto);
}
