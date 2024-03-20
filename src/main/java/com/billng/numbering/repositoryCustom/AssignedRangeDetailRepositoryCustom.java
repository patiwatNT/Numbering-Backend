package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.AssignedRangeDetailDto;

public interface AssignedRangeDetailRepositoryCustom {
    AssignedRangeDetailDto findByMainId(String id);
}
