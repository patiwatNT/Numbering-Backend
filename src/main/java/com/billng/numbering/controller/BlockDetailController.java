package com.billng.numbering.controller;

import com.billng.numbering.dto.BlockDetailDto;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.service.BlockDetailService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/block-detail")
@RestController
@Slf4j
@Api("block-detail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BlockDetailController {
    private final BlockDetailService blockDetailService;

    public BlockDetailController(BlockDetailService blockDetailService) {
        this.blockDetailService = blockDetailService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated BlockDetailDto blockDetailDto) {
        blockDetailService.save(blockDetailDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/findBlockDetail")
    public List<BlockDetailDto> findByCriteria(@RequestBody @Validated BlockDetailDtoC blockDetailDtoC){
        log.info("Controller Start");
        return blockDetailService.findByCriteria(blockDetailDtoC);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockDetailDto> findById(@PathVariable("id") BigDecimal id) {
        BlockDetailDto blockDetail = blockDetailService.findById(id);
        return ResponseEntity.ok(blockDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(blockDetailService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        blockDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<BlockDetailDto>> pageQuery(BlockDetailDto blockDetailDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BlockDetailDto> blockDetailPage = blockDetailService.findByCondition(blockDetailDto, pageable);
        return ResponseEntity.ok(blockDetailPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated BlockDetailDto blockDetailDto, @PathVariable("id") BigDecimal id) {
        blockDetailService.update(blockDetailDto, id);
        return ResponseEntity.ok().build();
    }
}
