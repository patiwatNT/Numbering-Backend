package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrProductTypeDto;
import com.billng.numbering.entities.NbrProductType;
import com.billng.numbering.mapper.NbrProductTypeMapper;
import com.billng.numbering.service.NbrProductTypeService;
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

@RequestMapping("/nbr-product-type")
@RestController
@Slf4j
@Api("nbr-product-type")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class NbrProductTypeController {
    private final NbrProductTypeService nbrProductTypeService;

    public NbrProductTypeController(NbrProductTypeService nbrProductTypeService) {
        this.nbrProductTypeService = nbrProductTypeService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrProductTypeDto nbrProductTypeDto) {
        nbrProductTypeService.save(nbrProductTypeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAllProductType")
    public List<String> findAll(){
        return nbrProductTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrProductTypeDto> findById(@PathVariable("id") Integer id) {
        NbrProductTypeDto nbrProductType = nbrProductTypeService.findById(id);
        return ResponseEntity.ok(nbrProductType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(nbrProductTypeService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrProductTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrProductTypeDto>> pageQuery(NbrProductTypeDto nbrProductTypeDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrProductTypeDto> nbrProductTypePage = nbrProductTypeService.findByCondition(nbrProductTypeDto, pageable);
        return ResponseEntity.ok(nbrProductTypePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrProductTypeDto nbrProductTypeDto, @PathVariable("id") Integer id) {
        nbrProductTypeService.update(nbrProductTypeDto, id);
        return ResponseEntity.ok().build();
    }
}
