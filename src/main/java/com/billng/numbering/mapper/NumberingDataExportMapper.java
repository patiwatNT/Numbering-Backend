package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingDataExportDto;
import com.billng.numbering.entities.NumberingDataExport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingDataExportMapper extends EntityMapper<NumberingDataExportDto, NumberingDataExport> {
}