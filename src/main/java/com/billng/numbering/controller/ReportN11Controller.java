package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN11Dto;
import com.billng.numbering.dtoC.LoginForm;
import com.billng.numbering.entities.ReportN11;
import com.billng.numbering.mapper.ReportN11Mapper;
import com.billng.numbering.service.LoginService;
import com.billng.numbering.service.ReportN11Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/report-n-11")
@RestController
@Slf4j
@Api("report-n-11")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN11Controller {
    private final ReportN11Service reportN11Service;

    public ReportN11Controller(ReportN11Service reportN11Service) {
        this.reportN11Service = reportN11Service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN11Dto reportN11Dto) {
        reportN11Service.save(reportN11Dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("findAll")
    public List<ReportN11Dto> findAll(){
        return reportN11Service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN11Dto> findById(@PathVariable("id") String id) {
        ReportN11Dto reportN11 = reportN11Service.findById(id);
        return ResponseEntity.ok(reportN11);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN11Service.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN11Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN11Dto>> pageQuery(ReportN11Dto reportN11Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN11Dto> reportN11Page = reportN11Service.findByCondition(reportN11Dto, pageable);
        return ResponseEntity.ok(reportN11Page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN11Dto reportN11Dto, @PathVariable("id") String id) {
        reportN11Service.update(reportN11Dto, id);
        return ResponseEntity.ok().build();
    }
}
