package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrServiceNumbersDto;
import com.billng.numbering.entities.NbrServiceNumbers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrServiceNumbersMapper extends EntityMapper<NbrServiceNumbersDto, NbrServiceNumbers> {
}