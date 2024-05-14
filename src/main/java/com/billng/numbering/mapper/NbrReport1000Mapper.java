package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrReport1000Dto;
import com.billng.numbering.entities.NbrReport1000;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrReport1000Mapper extends EntityMapper<NbrReport1000Dto, NbrReport1000> {
}