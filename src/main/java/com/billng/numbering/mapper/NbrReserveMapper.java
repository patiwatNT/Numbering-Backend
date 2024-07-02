package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrReserveDto;
import com.billng.numbering.entities.NbrReserve;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrReserveMapper extends EntityMapper<NbrReserveDto, NbrReserve> {
}