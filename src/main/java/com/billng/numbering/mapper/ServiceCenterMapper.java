package com.billng.numbering.mapper;

import com.billng.numbering.dto.ServiceCenterDto;
import com.billng.numbering.entities.ServiceCenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceCenterMapper extends EntityMapper<ServiceCenterDto, ServiceCenter> {
}