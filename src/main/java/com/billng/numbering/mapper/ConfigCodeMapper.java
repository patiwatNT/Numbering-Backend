package com.billng.numbering.mapper;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.entities.ConfigCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConfigCodeMapper extends EntityMapper<ConfigCodeDto, ConfigCode> {
}