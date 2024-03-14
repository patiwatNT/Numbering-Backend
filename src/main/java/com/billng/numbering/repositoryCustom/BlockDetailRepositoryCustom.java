package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.BlockDetailDto;

import java.util.List;

public interface BlockDetailRepositoryCustom {
    List<BlockDetailDto> findByCriteria(String query);
}
