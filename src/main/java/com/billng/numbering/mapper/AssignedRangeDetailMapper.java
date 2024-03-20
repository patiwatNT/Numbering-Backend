package com.billng.numbering.mapper;

import com.billng.numbering.dto.AssignedRangeDetailDto;
import com.billng.numbering.entities.AssignedRangeDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignedRangeDetailMapper extends EntityMapper<AssignedRangeDetailDto, AssignedRangeDetail> {
}