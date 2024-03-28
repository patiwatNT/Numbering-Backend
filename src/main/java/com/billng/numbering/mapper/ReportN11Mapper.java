package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN11Dto;
import com.billng.numbering.entities.ReportN11;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN11Mapper extends EntityMapper<ReportN11Dto, ReportN11> {
}