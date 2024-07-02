package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingDataExportDto;
import com.billng.numbering.dtoC.DataExport;
import com.billng.numbering.entities.NumberingDataExport;
import com.billng.numbering.mapper.NumberingDataExportMapper;
import com.billng.numbering.service.NumberingDataExportService;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/numbering-data-export")
@RestController
@Slf4j
@Api("numbering-data-export")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NumberingDataExportController {
    private final NumberingDataExportService numberingDataExportService;

    public NumberingDataExportController(NumberingDataExportService numberingDataExportService) {
        this.numberingDataExportService = numberingDataExportService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingDataExportDto numberingDataExportDto) {
        numberingDataExportService.save(numberingDataExportDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<NumberingDataExportDto> findAll(){
        return numberingDataExportService.findAll();
    }

    @GetMapping("/exportData/{providerId}")
    public List<DataExport> exportData(@PathVariable("providerId") String providerId){
        return numberingDataExportService.exportData(providerId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberingDataExportDto> findById(@PathVariable("id") String id) {
        NumberingDataExportDto numberingDataExport = numberingDataExportService.findById(id);
        return ResponseEntity.ok(numberingDataExport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(numberingDataExportService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingDataExportService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingDataExportDto>> pageQuery(NumberingDataExportDto numberingDataExportDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingDataExportDto> numberingDataExportPage = numberingDataExportService.findByCondition(numberingDataExportDto, pageable);
        return ResponseEntity.ok(numberingDataExportPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingDataExportDto numberingDataExportDto, @PathVariable("id") String id) {
        numberingDataExportService.update(numberingDataExportDto, id);
        return ResponseEntity.ok().build();
    }
}
