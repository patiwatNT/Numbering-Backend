package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrBlocksDto;

import java.util.List;

public interface NbrBlocksRepositoryCustom {
    NbrBlocksDto findByBlockId(int id);
    int countBlockByProvider(int providerId);

    List<NbrBlocksDto> findByCriteria(String query);
}
