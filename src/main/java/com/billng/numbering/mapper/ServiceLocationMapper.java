package com.billng.numbering.mapper;

import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.entities.ServiceLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceLocationMapper extends EntityMapper<ServiceLocationDto, ServiceLocation> {
}