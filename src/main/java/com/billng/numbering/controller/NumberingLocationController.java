package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.entities.NumberingLocation;
import com.billng.numbering.mapper.NumberingLocationMapper;
import com.billng.numbering.service.NumberingLocationService;
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

@RequestMapping("/numbering-location")
@RestController
@Slf4j
@Api("numbering-location")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NumberingLocationController {
    private final NumberingLocationService numberingLocationService;

    public NumberingLocationController(NumberingLocationService numberingLocationService) {
        this.numberingLocationService = numberingLocationService;
    }

    @GetMapping("/findAll")
    public List<NumberingLocationDto> findAll(){
        return numberingLocationService.findAllCustom();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingLocationDto numberingLocationDto) {
        numberingLocationService.save(numberingLocationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberingLocationDto> findById(@PathVariable("id") BigDecimal id) {
        NumberingLocationDto numberingLocation = numberingLocationService.findById(id);
        return ResponseEntity.ok(numberingLocation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(numberingLocationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingLocationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingLocationDto>> pageQuery(NumberingLocationDto numberingLocationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingLocationDto> numberingLocationPage = numberingLocationService.findByCondition(numberingLocationDto, pageable);
        return ResponseEntity.ok(numberingLocationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingLocationDto numberingLocationDto, @PathVariable("id") BigDecimal id) {
        numberingLocationService.update(numberingLocationDto, id);
        return ResponseEntity.ok().build();
    }
}
