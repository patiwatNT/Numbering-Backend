package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN13Dto;
import com.billng.numbering.entities.ReportN13;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN13Mapper extends EntityMapper<ReportN13Dto, ReportN13> {
}