package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrUsersRolesDto;
import com.billng.numbering.entities.NbrUsersRoles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrUsersRolesMapper extends EntityMapper<NbrUsersRolesDto, NbrUsersRoles> {
}