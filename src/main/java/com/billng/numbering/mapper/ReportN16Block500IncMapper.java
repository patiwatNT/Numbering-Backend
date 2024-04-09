package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN16Block500IncDto;
import com.billng.numbering.entities.ReportN16Block500Inc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN16Block500IncMapper extends EntityMapper<ReportN16Block500IncDto, ReportN16Block500Inc> {
}