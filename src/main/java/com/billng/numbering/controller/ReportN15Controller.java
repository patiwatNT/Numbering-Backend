package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN15Dto;
import com.billng.numbering.entities.ReportN15;
import com.billng.numbering.mapper.ReportN15Mapper;
import com.billng.numbering.service.ReportN15Service;
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

@RequestMapping("/report-n-15")
@RestController
@Slf4j
@Api("report-n-15")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class ReportN15Controller {
    private final ReportN15Service reportN15Service;

    public ReportN15Controller(ReportN15Service reportN15Service) {
        this.reportN15Service = reportN15Service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN15Dto reportN15Dto) {
        reportN15Service.save(reportN15Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<ReportN15Dto> findAll(){
        return reportN15Service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN15Dto> findById(@PathVariable("id") String id) {
        ReportN15Dto reportN15 = reportN15Service.findById(id);
        return ResponseEntity.ok(reportN15);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN15Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN15Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN15Dto>> pageQuery(ReportN15Dto reportN15Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN15Dto> reportN15Page = reportN15Service.findByCondition(reportN15Dto, pageable);
        return ResponseEntity.ok(reportN15Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN15Dto reportN15Dto, @PathVariable("id") String id) {
        reportN15Service.update(reportN15Dto, id);
        return ResponseEntity.ok().build();
    }
}
