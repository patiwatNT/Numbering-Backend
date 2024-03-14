package com.billng.numbering.mapper;

import com.billng.numbering.dto.BlockDetailDto;
import com.billng.numbering.entities.BlockDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlockDetailMapper extends EntityMapper<BlockDetailDto, BlockDetail> {
}