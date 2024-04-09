package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN16Block500OnlyDto;
import com.billng.numbering.entities.ReportN16Block500Only;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN16Block500OnlyMapper extends EntityMapper<ReportN16Block500OnlyDto, ReportN16Block500Only> {
}