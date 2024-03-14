package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NewsDto;

import java.util.List;

public interface NewsRepositoryCustom {
    List<NewsDto> findAllCustom();

    NewsDto findByIdCustom(String id);
}
