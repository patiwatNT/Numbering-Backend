package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrProductTypeDto;
import com.billng.numbering.entities.NbrProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrProductTypeMapper extends EntityMapper<NbrProductTypeDto, NbrProductType> {
}