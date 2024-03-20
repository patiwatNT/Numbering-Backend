package com.billng.numbering.mapper;

import com.billng.numbering.dto.PhoneDetailDto;
import com.billng.numbering.entities.PhoneDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneDetailMapper extends EntityMapper<PhoneDetailDto, PhoneDetail> {
}