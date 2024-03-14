package com.billng.numbering.mapper;

import com.billng.numbering.dto.AssignedRangeDto;
import com.billng.numbering.entities.AssignedRange;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignedRangeMapper extends EntityMapper<AssignedRangeDto, AssignedRange> {
}