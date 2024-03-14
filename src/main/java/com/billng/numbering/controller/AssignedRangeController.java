package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedRangeDto;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.entities.AssignedRange;
import com.billng.numbering.mapper.AssignedRangeMapper;
import com.billng.numbering.service.AssignedRangeService;
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

@RequestMapping("/assigned-range")
@RestController
@Slf4j
@Api("assigned-range")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AssignedRangeController {
    private final AssignedRangeService assignedRangeService;

    public AssignedRangeController(AssignedRangeService assignedRangeService) {
        this.assignedRangeService = assignedRangeService;
    }

    @PostMapping("/findByCriteria")
    public List<AssignedRangeDto> findByCriteria(@RequestBody @Validated AssignedRangeDtoC assignedRangeDtoC){
        return assignedRangeService.findByCriteria(assignedRangeDtoC);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated AssignedRangeDto assignedRangeDto) {
        assignedRangeService.save(assignedRangeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignedRangeDto> findById(@PathVariable("id") BigDecimal id) {
        AssignedRangeDto assignedRange = assignedRangeService.findById(id);
        return ResponseEntity.ok(assignedRange);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(assignedRangeService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        assignedRangeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<AssignedRangeDto>> pageQuery(AssignedRangeDto assignedRangeDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AssignedRangeDto> assignedRangePage = assignedRangeService.findByCondition(assignedRangeDto, pageable);
        return ResponseEntity.ok(assignedRangePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated AssignedRangeDto assignedRangeDto, @PathVariable("id") BigDecimal id) {
        assignedRangeService.update(assignedRangeDto, id);
        return ResponseEntity.ok().build();
    }
}
