package com.billng.numbering.mapper;

import com.billng.numbering.dto.PhoneInfoDto;
import com.billng.numbering.entities.PhoneInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneInfoMapper extends EntityMapper<PhoneInfoDto, PhoneInfo> {
}