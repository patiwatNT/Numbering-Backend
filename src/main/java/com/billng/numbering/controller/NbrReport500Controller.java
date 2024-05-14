package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrReport500Dto;
import com.billng.numbering.entities.NbrReport500;
import com.billng.numbering.mapper.NbrReport500Mapper;
import com.billng.numbering.service.NbrReport500Service;
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

@RequestMapping("/nbr-report-500")
@RestController
@Slf4j
@Api("nbr-report-500")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrReport500Controller {
    private final NbrReport500Service nbrReport500Service;

    public NbrReport500Controller(NbrReport500Service nbrReport500Service) {
        this.nbrReport500Service = nbrReport500Service;
    }

    @GetMapping("/findAll")
    public List<NbrReport500Dto> findAll(){
        return nbrReport500Service.findAll();
    }

    @GetMapping("/findAllOnly")
    public List<NbrReport500Dto> findAllOnly(){
        return nbrReport500Service.findAllOnly();
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody @Validated NbrReport500Dto nbrReport500Dto) {
//        nbrReport500Service.save(nbrReport500Dto);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NbrReport500Dto> findById(@PathVariable("id") String id) {
//        NbrReport500Dto nbrReport500 = nbrReport500Service.findById(id);
//        return ResponseEntity.ok(nbrReport500);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
//        Optional.ofNullable(nbrReport500Service.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data!");
//            return new ResourceNotFoundException();
//        });
//        nbrReport500Service.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/page-query")
//    public ResponseEntity<Page<NbrReport500Dto>> pageQuery(NbrReport500Dto nbrReport500Dto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<NbrReport500Dto> nbrReport500Page = nbrReport500Service.findByCondition(nbrReport500Dto, pageable);
//        return ResponseEntity.ok(nbrReport500Page);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody @Validated NbrReport500Dto nbrReport500Dto, @PathVariable("id") String id) {
//        nbrReport500Service.update(nbrReport500Dto, id);
//        return ResponseEntity.ok().build();
//    }
}
