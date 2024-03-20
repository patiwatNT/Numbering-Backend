package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.PhoneDetailDto;

import java.util.List;

public interface PhoneDetailRepositoryCustom {
    List<PhoneDetailDto> findByAssignRangeId(String assignRangeId);
}
