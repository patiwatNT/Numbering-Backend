package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.entities.ReportN16Block1000;
import com.billng.numbering.mapper.ReportN16Block1000Mapper;
import com.billng.numbering.service.ReportN16Block1000Service;
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

@RequestMapping("/report-n-16-block-1000")
@RestController
@Slf4j
@Api("report-n-16-block-1000")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN16Block1000Controller {
    private final ReportN16Block1000Service reportN16Block1000Service;

    public ReportN16Block1000Controller(ReportN16Block1000Service reportN16Block1000Service) {
        this.reportN16Block1000Service = reportN16Block1000Service;
    }

    @GetMapping("/findAll")
    public List<ReportN16Block1000Dto> findAll(){
        return reportN16Block1000Service.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN16Block1000Dto reportN16Block1000Dto) {
        reportN16Block1000Service.save(reportN16Block1000Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN16Block1000Dto> findById(@PathVariable("id") String id) {
        ReportN16Block1000Dto reportN16Block1000 = reportN16Block1000Service.findById(id);
        return ResponseEntity.ok(reportN16Block1000);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN16Block1000Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN16Block1000Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN16Block1000Dto>> pageQuery(ReportN16Block1000Dto reportN16Block1000Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN16Block1000Dto> reportN16Block1000Page = reportN16Block1000Service.findByCondition(reportN16Block1000Dto, pageable);
        return ResponseEntity.ok(reportN16Block1000Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN16Block1000Dto reportN16Block1000Dto, @PathVariable("id") String id) {
        reportN16Block1000Service.update(reportN16Block1000Dto, id);
        return ResponseEntity.ok().build();
    }
}
