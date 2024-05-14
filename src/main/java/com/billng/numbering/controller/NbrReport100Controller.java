package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrReport100Dto;
import com.billng.numbering.entities.NbrReport100;
import com.billng.numbering.mapper.NbrReport100Mapper;
import com.billng.numbering.service.NbrReport100Service;
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

@RequestMapping("/nbr-report-100")
@RestController
@Slf4j
@Api("nbr-report-100")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrReport100Controller {
    private final NbrReport100Service nbrReport100Service;

    public NbrReport100Controller(NbrReport100Service nbrReport100Service) {
        this.nbrReport100Service = nbrReport100Service;
    }

    @GetMapping("/findAll")
    public List<NbrReport100Dto> findAll(){
        return nbrReport100Service.findAll();
    }

    @GetMapping("/findAllOnly")
    public List<NbrReport100Dto> findAllOnly(){
        return nbrReport100Service.findAllOnly();
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody @Validated NbrReport100Dto nbrReport100Dto) {
//        nbrReport100Service.save(nbrReport100Dto);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NbrReport100Dto> findById(@PathVariable("id") String id) {
//        NbrReport100Dto nbrReport100 = nbrReport100Service.findById(id);
//        return ResponseEntity.ok(nbrReport100);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
//        Optional.ofNullable(nbrReport100Service.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data!");
//            return new ResourceNotFoundException();
//        });
//        nbrReport100Service.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/page-query")
//    public ResponseEntity<Page<NbrReport100Dto>> pageQuery(NbrReport100Dto nbrReport100Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<NbrReport100Dto> nbrReport100Page = nbrReport100Service.findByCondition(nbrReport100Dto, pageable);
//        return ResponseEntity.ok(nbrReport100Page);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody @Validated NbrReport100Dto nbrReport100Dto, @PathVariable("id") String id) {
//        nbrReport100Service.update(nbrReport100Dto, id);
//        return ResponseEntity.ok().build();
//    }
}
