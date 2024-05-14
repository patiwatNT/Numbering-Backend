package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN12Dto;
import com.billng.numbering.dtoC.NbrReportN12;
import com.billng.numbering.entities.ReportN12;
import com.billng.numbering.mapper.ReportN12Mapper;
import com.billng.numbering.service.ReportN12Service;
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

@RequestMapping("/report-n-12")
@RestController
@Slf4j
@Api("report-n-12")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN12Controller {
    private final ReportN12Service reportN12Service;

    public ReportN12Controller(ReportN12Service reportN12Service) {
        this.reportN12Service = reportN12Service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN12Dto reportN12Dto) {
        reportN12Service.save(reportN12Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("findAll")
    public List<NbrReportN12> findAll(){

        return reportN12Service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN12Dto> findById(@PathVariable("id") String id) {
        ReportN12Dto reportN12 = reportN12Service.findById(id);
        return ResponseEntity.ok(reportN12);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN12Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN12Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN12Dto>> pageQuery(ReportN12Dto reportN12Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN12Dto> reportN12Page = reportN12Service.findByCondition(reportN12Dto, pageable);
        return ResponseEntity.ok(reportN12Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN12Dto reportN12Dto, @PathVariable("id") String id) {
        reportN12Service.update(reportN12Dto, id);
        return ResponseEntity.ok().build();
    }
}
