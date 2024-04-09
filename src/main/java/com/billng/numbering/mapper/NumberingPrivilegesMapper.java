package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingPrivilegesDto;
import com.billng.numbering.entities.NumberingPrivileges;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingPrivilegesMapper extends EntityMapper<NumberingPrivilegesDto, NumberingPrivileges> {
}