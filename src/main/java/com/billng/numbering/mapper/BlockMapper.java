package com.billng.numbering.mapper;

import com.billng.numbering.dto.BlockDto;
import com.billng.numbering.entities.Block;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlockMapper extends EntityMapper<BlockDto, Block> {
}