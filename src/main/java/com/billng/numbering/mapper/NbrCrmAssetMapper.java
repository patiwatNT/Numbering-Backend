package com.billng.numbering.mapper;

import com.billng.numbering.dto.NbrCrmAssetDto;
import com.billng.numbering.entities.NbrCrmAsset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NbrCrmAssetMapper extends EntityMapper<NbrCrmAssetDto, NbrCrmAsset> {
}