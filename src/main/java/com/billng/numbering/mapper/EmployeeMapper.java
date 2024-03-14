package com.billng.numbering.mapper;

import com.billng.numbering.dto.EmployeeDto;
import com.billng.numbering.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee> {
}