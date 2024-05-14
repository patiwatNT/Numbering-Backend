package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrReport500Dto;
import com.billng.numbering.entities.NbrReport500;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrReport500Mapper extends EntityMapper<NbrReport500Dto, NbrReport500> {
}