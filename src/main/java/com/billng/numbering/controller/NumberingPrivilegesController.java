package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingPrivilegesDto;
import com.billng.numbering.entities.NumberingPrivileges;
import com.billng.numbering.mapper.NumberingPrivilegesMapper;
import com.billng.numbering.service.NumberingPrivilegesService;
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

@RequestMapping("/numbering-privileges")
@RestController
@Slf4j
@Api("numbering-privileges")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NumberingPrivilegesController {
    private final NumberingPrivilegesService numberingPrivilegesService;

    public NumberingPrivilegesController(NumberingPrivilegesService numberingPrivilegesService) {
        this.numberingPrivilegesService = numberingPrivilegesService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingPrivilegesDto numberingPrivilegesDto) {
        numberingPrivilegesService.save(numberingPrivilegesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<NumberingPrivilegesDto> findAll(){
        return numberingPrivilegesService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<NumberingPrivilegesDto> findById(@PathVariable("id") BigDecimal id) {
        NumberingPrivilegesDto numberingPrivileges = numberingPrivilegesService.findById(id);
        return ResponseEntity.ok(numberingPrivileges);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(numberingPrivilegesService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingPrivilegesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingPrivilegesDto>> pageQuery(NumberingPrivilegesDto numberingPrivilegesDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingPrivilegesDto> numberingPrivilegesPage = numberingPrivilegesService.findByCondition(numberingPrivilegesDto, pageable);
        return ResponseEntity.ok(numberingPrivilegesPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingPrivilegesDto numberingPrivilegesDto, @PathVariable("id") BigDecimal id) {
        numberingPrivilegesService.update(numberingPrivilegesDto, id);
        return ResponseEntity.ok().build();
    }
}
