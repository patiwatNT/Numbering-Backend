package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.entities.ReportN16Block1000;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN16Block1000Mapper extends EntityMapper<ReportN16Block1000Dto, ReportN16Block1000> {
}