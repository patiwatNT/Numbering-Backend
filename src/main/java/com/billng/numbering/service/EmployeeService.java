package com.billng.numbering.service;

import com.billng.numbering.dto.EmployeeDto;
import com.billng.numbering.entities.Employee;
import com.billng.numbering.mapper.EmployeeMapper;
import com.billng.numbering.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

@Slf4j
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper employeeMapper) {
        this.repository = repository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee entity = employeeMapper.toEntity(employeeDto);
        return employeeMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public EmployeeDto findById(Integer id) {
        return employeeMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<EmployeeDto> findByCondition(EmployeeDto employeeDto, Pageable pageable) {
        Page<Employee> entityPage = repository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(employeeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public EmployeeDto update(EmployeeDto employeeDto, Integer id) {
        EmployeeDto data = findById(id);
        Employee entity = employeeMapper.toEntity(employeeDto);
        //BeanUtil.copyProperties(data, entity);
        return save(employeeMapper.toDto(entity));
    }
}
