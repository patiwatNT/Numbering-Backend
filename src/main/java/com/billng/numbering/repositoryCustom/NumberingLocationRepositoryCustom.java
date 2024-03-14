package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NumberingLocationDto;

import java.util.List;

public interface NumberingLocationRepositoryCustom {
    List<NumberingLocationDto> findAllCustom();
}
