package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedRangeDetailDto;
import com.billng.numbering.entities.AssignedRangeDetail;
import com.billng.numbering.entities.AssignedRangeDetailPK;
import com.billng.numbering.mapper.AssignedRangeDetailMapper;
import com.billng.numbering.service.AssignedRangeDetailService;
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

@RequestMapping("/assigned-range-detail")
@RestController
@Slf4j
@Api("assigned-range-detail")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AssignedRangeDetailController {
    private final AssignedRangeDetailService assignedRangeDetailService;

    public AssignedRangeDetailController(AssignedRangeDetailService assignedRangeDetailService) {
        this.assignedRangeDetailService = assignedRangeDetailService;
    }

    @GetMapping("/findByMainId/{id}")
    public AssignedRangeDetailDto findByMainId(@PathVariable("id") String id){
       return assignedRangeDetailService.findByMainId(id);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated AssignedRangeDetailDto assignedRangeDetailDto) {
        assignedRangeDetailService.save(assignedRangeDetailDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignedRangeDetailDto> findById(@PathVariable("id") AssignedRangeDetailPK id) {
        AssignedRangeDetailDto assignedRangeDetail = assignedRangeDetailService.findById(id);
        return ResponseEntity.ok(assignedRangeDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") AssignedRangeDetailPK id) {
        Optional.ofNullable(assignedRangeDetailService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        assignedRangeDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<AssignedRangeDetailDto>> pageQuery(AssignedRangeDetailDto assignedRangeDetailDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AssignedRangeDetailDto> assignedRangeDetailPage = assignedRangeDetailService.findByCondition(assignedRangeDetailDto, pageable);
        return ResponseEntity.ok(assignedRangeDetailPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated AssignedRangeDetailDto assignedRangeDetailDto, @PathVariable("id") AssignedRangeDetailPK id) {
        assignedRangeDetailService.update(assignedRangeDetailDto, id);
        return ResponseEntity.ok().build();
    }
}
