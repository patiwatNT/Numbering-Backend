package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingRolesDto;
import com.billng.numbering.entities.NumberingRoles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingRolesMapper extends EntityMapper<NumberingRolesDto, NumberingRoles> {
}