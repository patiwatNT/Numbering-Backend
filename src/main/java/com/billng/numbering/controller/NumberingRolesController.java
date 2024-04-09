package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingRolesDto;
import com.billng.numbering.entities.NumberingRoles;
import com.billng.numbering.mapper.NumberingRolesMapper;
import com.billng.numbering.service.NumberingRolesService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/numbering-roles")
@RestController
@Slf4j
@Api("numbering-roles")
public class NumberingRolesController {
    private final NumberingRolesService numberingRolesService;

    public NumberingRolesController(NumberingRolesService numberingRolesService) {
        this.numberingRolesService = numberingRolesService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingRolesDto numberingRolesDto) {
        numberingRolesService.save(numberingRolesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberingRolesDto> findById(@PathVariable("id") BigDecimal id) {
        NumberingRolesDto numberingRoles = numberingRolesService.findById(id);
        return ResponseEntity.ok(numberingRoles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(numberingRolesService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingRolesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingRolesDto>> pageQuery(NumberingRolesDto numberingRolesDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingRolesDto> numberingRolesPage = numberingRolesService.findByCondition(numberingRolesDto, pageable);
        return ResponseEntity.ok(numberingRolesPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingRolesDto numberingRolesDto, @PathVariable("id") BigDecimal id) {
        numberingRolesService.update(numberingRolesDto, id);
        return ResponseEntity.ok().build();
    }
}
