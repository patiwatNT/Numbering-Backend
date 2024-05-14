package com.billng.numbering.mapper;

import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.entities.TOTServiceCenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TOTServiceCenterMapper extends EntityMapper<TOTServiceCenterDto, TOTServiceCenter> {
}