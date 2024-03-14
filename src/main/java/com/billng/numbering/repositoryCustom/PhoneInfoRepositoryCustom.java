package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.PhoneInfoDto;

public interface PhoneInfoRepositoryCustom {
    PhoneInfoDto findByIdCustom(String id);
}
