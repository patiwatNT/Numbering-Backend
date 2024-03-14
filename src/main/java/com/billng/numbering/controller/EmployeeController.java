package com.billng.numbering.controller;

import com.billng.numbering.dto.EmployeeDto;
import com.billng.numbering.service.EmployeeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

@RequestMapping("/api/employee")
@RestController
@Slf4j
@Api("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("id") Integer id) {
        EmployeeDto employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(employeeService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<EmployeeDto>> pageQuery(EmployeeDto employeeDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<EmployeeDto> employeePage = employeeService.findByCondition(employeeDto, pageable);
        return ResponseEntity.ok(employeePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated EmployeeDto employeeDto, @PathVariable("id") Integer id) {
        employeeService.update(employeeDto, id);
        return ResponseEntity.ok().build();
    }
}
