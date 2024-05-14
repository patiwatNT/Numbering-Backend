package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN13Dto;
import com.billng.numbering.dtoC.NbrReportN13;
import com.billng.numbering.entities.ReportN13;
import com.billng.numbering.mapper.ReportN13Mapper;
import com.billng.numbering.service.ReportN13Service;
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

@RequestMapping("/report-n-13")
@RestController
@Slf4j
@Api("report-n-13")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN13Controller {
    private final ReportN13Service reportN13Service;

    public ReportN13Controller(ReportN13Service reportN13Service) {
        this.reportN13Service = reportN13Service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN13Dto reportN13Dto) {
        reportN13Service.save(reportN13Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<NbrReportN13> findAll(){
        return reportN13Service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN13Dto> findById(@PathVariable("id") String id) {
        ReportN13Dto reportN13 = reportN13Service.findById(id);
        return ResponseEntity.ok(reportN13);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN13Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN13Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN13Dto>> pageQuery(ReportN13Dto reportN13Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN13Dto> reportN13Page = reportN13Service.findByCondition(reportN13Dto, pageable);
        return ResponseEntity.ok(reportN13Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN13Dto reportN13Dto, @PathVariable("id") String id) {
        reportN13Service.update(reportN13Dto, id);
        return ResponseEntity.ok().build();
    }
}
