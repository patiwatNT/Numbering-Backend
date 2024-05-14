package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrReportDto;
import com.billng.numbering.entities.NbrReport;
import com.billng.numbering.mapper.NbrReportMapper;
import com.billng.numbering.service.NbrReportService;
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

@RequestMapping("/nbr-report")
@RestController
@Slf4j
@Api("nbr-report")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrReportController {
    private final NbrReportService nbrReportService;

    public NbrReportController(NbrReportService nbrReportService) {
        this.nbrReportService = nbrReportService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrReportDto nbrReportDto) {
        nbrReportService.save(nbrReportDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    List<NbrReportDto> findAll(){
        return nbrReportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrReportDto> findById(@PathVariable("id") String id) {
        NbrReportDto nbrReport = nbrReportService.findById(id);
        return ResponseEntity.ok(nbrReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(nbrReportService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrReportService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrReportDto>> pageQuery(NbrReportDto nbrReportDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrReportDto> nbrReportPage = nbrReportService.findByCondition(nbrReportDto, pageable);
        return ResponseEntity.ok(nbrReportPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrReportDto nbrReportDto, @PathVariable("id") String id) {
        nbrReportService.update(nbrReportDto, id);
        return ResponseEntity.ok().build();
    }
}
