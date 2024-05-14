package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrAssignedDto;
import com.billng.numbering.entities.NbrAssigned;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrAssignedMapper extends EntityMapper<NbrAssignedDto, NbrAssigned> {
}