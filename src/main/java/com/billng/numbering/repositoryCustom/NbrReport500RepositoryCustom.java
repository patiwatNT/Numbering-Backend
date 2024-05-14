package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrReport500Dto;

import java.util.List;

public interface NbrReport500RepositoryCustom {
    List<NbrReport500Dto> findAllOnly();
}
