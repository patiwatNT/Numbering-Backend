package com.billng.numbering.mapper;

import com.billng.numbering.dto.NtStaffDto;
import com.billng.numbering.entities.NtStaff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NtStaffMapper extends EntityMapper<NtStaffDto, NtStaff> {
}