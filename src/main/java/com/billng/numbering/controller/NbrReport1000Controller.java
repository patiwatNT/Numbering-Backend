package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrReport1000Dto;
import com.billng.numbering.dtoC.NbrReportN16;
import com.billng.numbering.entities.NbrReport1000;
import com.billng.numbering.mapper.NbrReport1000Mapper;
import com.billng.numbering.service.NbrReport1000Service;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/nbr-report-1000")
@RestController
@Slf4j
@Api("nbr-report-1000")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrReport1000Controller {
    private final NbrReport1000Service nbrReport1000Service;

    public NbrReport1000Controller(NbrReport1000Service nbrReport1000Service) {
        this.nbrReport1000Service = nbrReport1000Service;
    }

    @GetMapping("/findReportN16Inc")
    public List<NbrReportN16> findReportN16Inc(){
        return nbrReport1000Service.findReportN16Inc();
    }

    @GetMapping("/findReportN16Only")
    public List<NbrReportN16> findReportN16Only(){
        return nbrReport1000Service.findReportN16Only();
    }

    @GetMapping("findAll")
    public List<NbrReport1000Dto> findAll(){
        return nbrReport1000Service.findAll();
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody @Validated NbrReport1000Dto nbrReport1000Dto) {
//        nbrReport1000Service.save(nbrReport1000Dto);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NbrReport1000Dto> findById(@PathVariable("id") String id) {
//        NbrReport1000Dto nbrReport1000 = nbrReport1000Service.findById(id);
//        return ResponseEntity.ok(nbrReport1000);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
//        Optional.ofNullable(nbrReport1000Service.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data!");
//            return new ResourceNotFoundException();
//        });
//        nbrReport1000Service.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/page-query")
//    public ResponseEntity<Page<NbrReport1000Dto>> pageQuery(NbrReport1000Dto nbrReport1000Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<NbrReport1000Dto> nbrReport1000Page = nbrReport1000Service.findByCondition(nbrReport1000Dto, pageable);
//        return ResponseEntity.ok(nbrReport1000Page);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody @Validated NbrReport1000Dto nbrReport1000Dto, @PathVariable("id") String id) {
//        nbrReport1000Service.update(nbrReport1000Dto, id);
//        return ResponseEntity.ok().build();
//    }
}
