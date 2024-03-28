package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingReportDto;
import com.billng.numbering.entities.NumberingReport;
import com.billng.numbering.mapper.NumberingReportMapper;
import com.billng.numbering.service.NumberingReportService;
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

@RequestMapping("/numbering-report")
@RestController
@Slf4j
@Api("numbering-report")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NumberingReportController {
    private final NumberingReportService numberingReportService;

    public NumberingReportController(NumberingReportService numberingReportService) {
        this.numberingReportService = numberingReportService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingReportDto numberingReportDto) {
        numberingReportService.save(numberingReportDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<NumberingReportDto> findAll(){
        return numberingReportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberingReportDto> findById(@PathVariable("id") String id) {
        NumberingReportDto numberingReport = numberingReportService.findById(id);
        return ResponseEntity.ok(numberingReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(numberingReportService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingReportService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingReportDto>> pageQuery(NumberingReportDto numberingReportDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingReportDto> numberingReportPage = numberingReportService.findByCondition(numberingReportDto, pageable);
        return ResponseEntity.ok(numberingReportPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingReportDto numberingReportDto, @PathVariable("id") String id) {
        numberingReportService.update(numberingReportDto, id);
        return ResponseEntity.ok().build();
    }
}
