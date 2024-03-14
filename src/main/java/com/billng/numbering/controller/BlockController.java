package com.billng.numbering.controller;

import com.billng.numbering.dto.BlockDto;
import com.billng.numbering.entities.Block;
import com.billng.numbering.mapper.BlockMapper;
import com.billng.numbering.service.BlockService;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/block")
@RestController
@Slf4j
@Api("block")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated BlockDto blockDto) {
        blockService.save(blockDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<BlockDto> findAll(){
        return blockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockDto> findById(@PathVariable("id") BigDecimal id) {
        BlockDto block = blockService.findById(id);
        return ResponseEntity.ok(block);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(blockService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        blockService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<BlockDto>> pageQuery(BlockDto blockDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BlockDto> blockPage = blockService.findByCondition(blockDto, pageable);
        return ResponseEntity.ok(blockPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated BlockDto blockDto, @PathVariable("id") BigDecimal id) {
        blockService.update(blockDto, id);
        return ResponseEntity.ok().build();
    }
}
