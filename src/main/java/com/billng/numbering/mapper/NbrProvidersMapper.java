package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrProvidersDto;
import com.billng.numbering.entities.NbrProviders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrProvidersMapper extends EntityMapper<NbrProvidersDto, NbrProviders> {
}