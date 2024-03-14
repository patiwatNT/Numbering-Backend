package com.billng.numbering.mapper;

import com.billng.numbering.dto.AssignedDto;
import com.billng.numbering.entities.Assigned;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignedMapper extends EntityMapper<AssignedDto, Assigned> {
}