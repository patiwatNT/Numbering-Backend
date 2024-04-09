package com.billng.numbering.controller;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block500OnlyDto;
import com.billng.numbering.entities.ReportN16Block500Only;
import com.billng.numbering.mapper.ReportN16Block500OnlyMapper;
import com.billng.numbering.service.ReportN16Block500OnlyService;
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

@RequestMapping("/report-n-16-block-500-only")
@RestController
@Slf4j
@Api("report-n-16-block-500-only")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ReportN16Block500OnlyController {
    private final ReportN16Block500OnlyService reportN16Block500OnlyService;

    public ReportN16Block500OnlyController(ReportN16Block500OnlyService reportN16Block500OnlyService) {
        this.reportN16Block500OnlyService = reportN16Block500OnlyService;
    }
    @GetMapping("/findAll")
    public List<ReportN16Block500OnlyDto> findAll(){
        return reportN16Block500OnlyService.findAll();
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ReportN16Block500OnlyDto reportN16Block500OnlyDto) {
        reportN16Block500OnlyService.save(reportN16Block500OnlyDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportN16Block500OnlyDto> findById(@PathVariable("id") String id) {
        ReportN16Block500OnlyDto reportN16Block500Only = reportN16Block500OnlyService.findById(id);
        return ResponseEntity.ok(reportN16Block500Only);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(reportN16Block500OnlyService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        reportN16Block500OnlyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ReportN16Block500OnlyDto>> pageQuery(ReportN16Block500OnlyDto reportN16Block500OnlyDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportN16Block500OnlyDto> reportN16Block500OnlyPage = reportN16Block500OnlyService.findByCondition(reportN16Block500OnlyDto, pageable);
        return ResponseEntity.ok(reportN16Block500OnlyPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ReportN16Block500OnlyDto reportN16Block500OnlyDto, @PathVariable("id") String id) {
        reportN16Block500OnlyService.update(reportN16Block500OnlyDto, id);
        return ResponseEntity.ok().build();
    }
}
