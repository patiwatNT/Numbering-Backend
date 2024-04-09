package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block100OnlyDto;
import com.billng.numbering.entities.ReportN16Block100Only;
import com.billng.numbering.mapper.ReportN16Block100OnlyMapper;
import com.billng.numbering.service.ReportN16Block100OnlyService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/report-n-16-block-100-only")
@RestController
@Slf4j
@Api("report-n-16-block-100-only")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN16Block100OnlyController {
    private final ReportN16Block100OnlyService reportN16Block100OnlyService;

    public ReportN16Block100OnlyController(ReportN16Block100OnlyService reportN16Block100OnlyService) {
        this.reportN16Block100OnlyService = reportN16Block100OnlyService;
    }
    @GetMapping("/findAll")
    public List<ReportN16Block100OnlyDto> findAll(){
        return reportN16Block100OnlyService.findAll();
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN16Block100OnlyDto reportN16Block100OnlyDto) {
        reportN16Block100OnlyService.save(reportN16Block100OnlyDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN16Block100OnlyDto> findById(@PathVariable("id") String id) {
        ReportN16Block100OnlyDto reportN16Block100Only = reportN16Block100OnlyService.findById(id);
        return ResponseEntity.ok(reportN16Block100Only);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN16Block100OnlyService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN16Block100OnlyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN16Block100OnlyDto>> pageQuery(ReportN16Block100OnlyDto reportN16Block100OnlyDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN16Block100OnlyDto> reportN16Block100OnlyPage = reportN16Block100OnlyService.findByCondition(reportN16Block100OnlyDto, pageable);
        return ResponseEntity.ok(reportN16Block100OnlyPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN16Block100OnlyDto reportN16Block100OnlyDto, @PathVariable("id") String id) {
        reportN16Block100OnlyService.update(reportN16Block100OnlyDto, id);
        return ResponseEntity.ok().build();
    }
}
