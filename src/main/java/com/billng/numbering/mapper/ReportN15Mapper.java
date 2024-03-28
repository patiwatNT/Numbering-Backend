package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN15Dto;
import com.billng.numbering.entities.ReportN15;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN15Mapper extends EntityMapper<ReportN15Dto, ReportN15> {
}