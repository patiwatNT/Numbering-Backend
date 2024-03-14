package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedDto;
import com.billng.numbering.entities.Assigned;
import com.billng.numbering.mapper.AssignedMapper;
import com.billng.numbering.service.AssignedService;
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

@RequestMapping("/assigned")
@RestController
@Slf4j
@Api("assigned")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AssignedController {
    private final AssignedService assignedService;

    public AssignedController(AssignedService assignedService) {
        this.assignedService = assignedService;
    }

    @GetMapping("/findAll")
    public List<AssignedDto> findAll(){
        return assignedService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated AssignedDto assignedDto) {
        assignedService.save(assignedDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignedDto> findById(@PathVariable("id") BigDecimal id) {
        AssignedDto assigned = assignedService.findById(id);
        return ResponseEntity.ok(assigned);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(assignedService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        assignedService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<AssignedDto>> pageQuery(AssignedDto assignedDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AssignedDto> assignedPage = assignedService.findByCondition(assignedDto, pageable);
        return ResponseEntity.ok(assignedPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated AssignedDto assignedDto, @PathVariable("id") BigDecimal id) {
        assignedService.update(assignedDto, id);
        return ResponseEntity.ok().build();
    }
}
