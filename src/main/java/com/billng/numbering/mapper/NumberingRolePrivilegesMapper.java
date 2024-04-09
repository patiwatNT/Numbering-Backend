package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.entities.NumberingRolePrivileges;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NumberingRolePrivilegesMapper extends EntityMapper<NumberingRolePrivilegesDto, NumberingRolePrivileges> {
}