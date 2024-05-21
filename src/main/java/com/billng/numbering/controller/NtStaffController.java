package com.billng.numbering.controller;

import com.billng.numbering.dto.NtStaffDto;
import com.billng.numbering.entities.NtStaff;
import com.billng.numbering.mapper.NtStaffMapper;
import com.billng.numbering.service.NtStaffService;
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

@RequestMapping("/nt-staff")
@RestController
@Slf4j
@Api("nt-staff")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NtStaffController {
    private final NtStaffService ntStaffService;

    public NtStaffController(NtStaffService ntStaffService) {
        this.ntStaffService = ntStaffService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NtStaffDto ntStaffDto) {
        ntStaffService.save(ntStaffDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByEmpCode/{empCode}")
    public NtStaffDto findByEmpCode(@PathVariable("empCode") String empCode){
       return ntStaffService.findByEmpCode(empCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NtStaffDto> findById(@PathVariable("id") String id) {
        NtStaffDto ntStaff = ntStaffService.findById(id);
        return ResponseEntity.ok(ntStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(ntStaffService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        ntStaffService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NtStaffDto>> pageQuery(NtStaffDto ntStaffDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NtStaffDto> ntStaffPage = ntStaffService.findByCondition(ntStaffDto, pageable);
        return ResponseEntity.ok(ntStaffPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NtStaffDto ntStaffDto, @PathVariable("id") String id) {
        ntStaffService.update(ntStaffDto, id);
        return ResponseEntity.ok().build();
    }
}
