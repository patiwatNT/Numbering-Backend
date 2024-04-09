package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NumberingUsersDto;

public interface NumberingUsersRepositoryCustom {
    NumberingUsersDto findByUsername(String username);
}
