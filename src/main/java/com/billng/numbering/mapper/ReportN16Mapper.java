package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN16Dto;
import com.billng.numbering.entities.ReportN16;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN16Mapper extends EntityMapper<ReportN16Dto, ReportN16> {
}