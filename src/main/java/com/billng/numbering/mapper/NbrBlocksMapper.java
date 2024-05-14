package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrBlocksDto;
import com.billng.numbering.entities.NbrBlocks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrBlocksMapper extends EntityMapper<NbrBlocksDto, NbrBlocks> {
}