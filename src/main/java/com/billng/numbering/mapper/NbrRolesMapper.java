package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrRolesDto;
import com.billng.numbering.entities.NbrRoles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrRolesMapper extends EntityMapper<NbrRolesDto, NbrRoles> {
}