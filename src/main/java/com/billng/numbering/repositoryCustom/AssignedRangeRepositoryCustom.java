package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.AssignedRangeDto;

import java.util.List;

public interface AssignedRangeRepositoryCustom {
    List<AssignedRangeDto> findByCriteria(String query);
}
