package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrReportDto;
import com.billng.numbering.entities.NbrReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrReportMapper extends EntityMapper<NbrReportDto, NbrReport> {
}