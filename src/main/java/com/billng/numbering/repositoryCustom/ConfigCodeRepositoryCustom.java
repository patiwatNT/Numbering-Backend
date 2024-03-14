package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.ConfigCodeDto;

import java.util.List;

public interface ConfigCodeRepositoryCustom {
    List<ConfigCodeDto> findByStatusGroup(String statusGroup);
}
