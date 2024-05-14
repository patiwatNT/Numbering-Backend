package com.billng.numbering.controller;

import com.billng.numbering.dto.BlockDto;
import com.billng.numbering.dto.NbrBlocksDto;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.entities.NbrBlocks;
import com.billng.numbering.mapper.NbrBlocksMapper;
import com.billng.numbering.service.NbrBlocksService;
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

@RequestMapping("/nbr-blocks")
@RestController
@Slf4j
@Api("nbr-blocks")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrBlocksController {
    private final NbrBlocksService nbrBlocksService;

    public NbrBlocksController(NbrBlocksService nbrBlocksService) {
        this.nbrBlocksService = nbrBlocksService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrBlocksDto nbrBlocksDto) {
        nbrBlocksService.save(nbrBlocksDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByBlockId/{id}")
    public NbrBlocksDto findByBlockId(@PathVariable("id") int id){
        return nbrBlocksService.findByBlockId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrBlocksDto> findById(@PathVariable("id") Integer id) {
        NbrBlocksDto nbrBlocks = nbrBlocksService.findById(id);
        return ResponseEntity.ok(nbrBlocks);
    }
    @GetMapping("/getBlockList")
    public List<BlockDto> getBlockList(){
        return nbrBlocksService.getBlockList();
    }

    @PostMapping("/findBlockDetail")
    public List<NbrBlocksDto> findAllBlockByProvider(@RequestBody @Validated BlockDetailDtoC blockDetailDtoC){
        return nbrBlocksService.findByCriteria(blockDetailDtoC);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(nbrBlocksService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrBlocksService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrBlocksDto>> pageQuery(NbrBlocksDto nbrBlocksDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrBlocksDto> nbrBlocksPage = nbrBlocksService.findByCondition(nbrBlocksDto, pageable);
        return ResponseEntity.ok(nbrBlocksPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrBlocksDto nbrBlocksDto, @PathVariable("id") Integer id) {
        nbrBlocksService.update(nbrBlocksDto, id);
        return ResponseEntity.ok().build();
    }
}
