package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block500IncDto;
import com.billng.numbering.entities.ReportN16Block500Inc;
import com.billng.numbering.mapper.ReportN16Block500IncMapper;
import com.billng.numbering.service.ReportN16Block500IncService;
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

@RequestMapping("/report-n-16-block-500-inc")
@RestController
@Slf4j
@Api("report-n-16-block-500-inc")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN16Block500IncController {
    private final ReportN16Block500IncService reportN16Block500IncService;

    public ReportN16Block500IncController(ReportN16Block500IncService reportN16Block500IncService) {
        this.reportN16Block500IncService = reportN16Block500IncService;
    }
    @GetMapping("/findAll")
    public List<ReportN16Block500IncDto> findAll(){
        return reportN16Block500IncService.findAll();
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN16Block500IncDto reportN16Block500IncDto) {
        reportN16Block500IncService.save(reportN16Block500IncDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN16Block500IncDto> findById(@PathVariable("id") String id) {
        ReportN16Block500IncDto reportN16Block500Inc = reportN16Block500IncService.findById(id);
        return ResponseEntity.ok(reportN16Block500Inc);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN16Block500IncService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN16Block500IncService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN16Block500IncDto>> pageQuery(ReportN16Block500IncDto reportN16Block500IncDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN16Block500IncDto> reportN16Block500IncPage = reportN16Block500IncService.findByCondition(reportN16Block500IncDto, pageable);
        return ResponseEntity.ok(reportN16Block500IncPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN16Block500IncDto reportN16Block500IncDto, @PathVariable("id") String id) {
        reportN16Block500IncService.update(reportN16Block500IncDto, id);
        return ResponseEntity.ok().build();
    }
}
