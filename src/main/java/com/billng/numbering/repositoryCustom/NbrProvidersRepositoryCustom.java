package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrProvidersDto;

public interface NbrProvidersRepositoryCustom {
    NbrProvidersDto findByProviderId(String id);
}
