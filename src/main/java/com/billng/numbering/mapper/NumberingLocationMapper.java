package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.entities.NumberingLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingLocationMapper extends EntityMapper<NumberingLocationDto, NumberingLocation> {
}