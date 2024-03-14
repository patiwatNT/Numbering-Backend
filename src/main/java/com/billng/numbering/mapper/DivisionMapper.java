package com.billng.numbering.mapper;

import com.billng.numbering.dto.DivisionDto;
import com.billng.numbering.entities.Division;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DivisionMapper extends EntityMapper<DivisionDto, Division> {
}