package com.billng.numbering.controller;

import com.billng.numbering.dto.DivisionDto;
import com.billng.numbering.entities.Division;
import com.billng.numbering.mapper.DivisionMapper;
import com.billng.numbering.service.DivisionService;
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

@RequestMapping("/division")
@RestController
@Slf4j
@Api("division")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DivisionController {
    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/findAll")
    public List<DivisionDto> findAll(){
        return divisionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated DivisionDto divisionDto) {
        divisionService.save(divisionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionDto> findById(@PathVariable("id") BigDecimal id) {
        DivisionDto division = divisionService.findById(id);
        return ResponseEntity.ok(division);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(divisionService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        divisionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<DivisionDto>> pageQuery(DivisionDto divisionDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<DivisionDto> divisionPage = divisionService.findByCondition(divisionDto, pageable);
        return ResponseEntity.ok(divisionPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated DivisionDto divisionDto, @PathVariable("id") BigDecimal id) {
        divisionService.update(divisionDto, id);
        return ResponseEntity.ok().build();
    }
}
