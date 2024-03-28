package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingReportDto;
import com.billng.numbering.entities.NumberingReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingReportMapper extends EntityMapper<NumberingReportDto, NumberingReport> {
}