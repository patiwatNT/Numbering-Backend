package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrReport100Dto;
import com.billng.numbering.entities.NbrReport100;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrReport100Mapper extends EntityMapper<NbrReport100Dto, NbrReport100> {
}