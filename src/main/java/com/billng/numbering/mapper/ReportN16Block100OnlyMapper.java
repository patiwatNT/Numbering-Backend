package com.billng.numbering.mapper;

import com.billng.numbering.dto.ReportN16Block100OnlyDto;
import com.billng.numbering.entities.ReportN16Block100Only;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportN16Block100OnlyMapper extends EntityMapper<ReportN16Block100OnlyDto, ReportN16Block100Only> {
}