package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN12Dto;
import com.billng.numbering.entities.ReportN12;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN12Mapper extends EntityMapper<ReportN12Dto, ReportN12> {
}