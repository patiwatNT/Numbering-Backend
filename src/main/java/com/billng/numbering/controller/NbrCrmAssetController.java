package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrCrmAssetDto;
import com.billng.numbering.entities.NbrCrmAsset;
import com.billng.numbering.mapper.NbrCrmAssetMapper;
import com.billng.numbering.service.NbrCrmAssetService;
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

@RequestMapping("/nbr-crm-asset")
@RestController
@Slf4j
@Api("nbr-crm-asset")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrCrmAssetController {
    private final NbrCrmAssetService nbrCrmAssetService;

    public NbrCrmAssetController(NbrCrmAssetService nbrCrmAssetService) {
        this.nbrCrmAssetService = nbrCrmAssetService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrCrmAssetDto nbrCrmAssetDto) {
        nbrCrmAssetService.save(nbrCrmAssetDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrCrmAssetDto> findById(@PathVariable("id") String id) {
        NbrCrmAssetDto nbrCrmAsset = nbrCrmAssetService.findById(id);
        return ResponseEntity.ok(nbrCrmAsset);
    }

    @GetMapping("/findByTelNo/{telNo}")
    public NbrCrmAssetDto findByTelNo(@PathVariable("telNo") String telNo){
        return nbrCrmAssetService.findByTelNo(telNo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(nbrCrmAssetService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrCrmAssetService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrCrmAssetDto>> pageQuery(NbrCrmAssetDto nbrCrmAssetDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrCrmAssetDto> nbrCrmAssetPage = nbrCrmAssetService.findByCondition(nbrCrmAssetDto, pageable);
        return ResponseEntity.ok(nbrCrmAssetPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrCrmAssetDto nbrCrmAssetDto, @PathVariable("id") String id) {
        nbrCrmAssetService.update(nbrCrmAssetDto, id);
        return ResponseEntity.ok().build();
    }
}
