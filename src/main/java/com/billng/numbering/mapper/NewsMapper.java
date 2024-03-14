package com.billng.numbering.mapper;

import com.billng.numbering.dto.NewsDto;
import com.billng.numbering.entities.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper extends EntityMapper<NewsDto, News> {
}