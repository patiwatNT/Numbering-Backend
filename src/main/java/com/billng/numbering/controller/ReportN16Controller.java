package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Dto;
import com.billng.numbering.entities.ReportN16;
import com.billng.numbering.mapper.ReportN16Mapper;
import com.billng.numbering.service.ReportN16Service;
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

@RequestMapping("/report-n-16")
@RestController
@Slf4j
@Api("report-n-16")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN16Controller {
    private final ReportN16Service reportN16Service;

    public ReportN16Controller(ReportN16Service reportN16Service) {
        this.reportN16Service = reportN16Service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN16Dto reportN16Dto) {
        reportN16Service.save(reportN16Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<ReportN16Dto> findAll(){
        return reportN16Service.findAll();    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN16Dto> findById(@PathVariable("id") String id) {
        ReportN16Dto reportN16 = reportN16Service.findById(id);
        return ResponseEntity.ok(reportN16);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN16Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN16Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN16Dto>> pageQuery(ReportN16Dto reportN16Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN16Dto> reportN16Page = reportN16Service.findByCondition(reportN16Dto, pageable);
        return ResponseEntity.ok(reportN16Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN16Dto reportN16Dto, @PathVariable("id") String id) {
        reportN16Service.update(reportN16Dto, id);
        return ResponseEntity.ok().build();
    }
}
