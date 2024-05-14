package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrCrmAssetDto;

public interface NbrCrmAssetRepositoryCustom {
    NbrCrmAssetDto findByTelNo(String telNo);
}
