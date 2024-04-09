package com.billng.numbering.mapper;

import com.billng.numbering.dto.NumberingUsersDto;
import com.billng.numbering.entities.NumberingUsers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NumberingUsersMapper extends EntityMapper<NumberingUsersDto, NumberingUsers> {
}