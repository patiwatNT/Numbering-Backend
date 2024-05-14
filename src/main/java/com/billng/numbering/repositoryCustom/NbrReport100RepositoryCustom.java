package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrReport100Dto;

import java.util.List;

public interface NbrReport100RepositoryCustom {
    List<NbrReport100Dto> findAllOnly();
}
