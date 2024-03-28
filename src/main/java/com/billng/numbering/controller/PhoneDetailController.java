package com.billng.numbering.controller;

import com.billng.numbering.dto.PhoneDetailDto;
import com.billng.numbering.entities.PhoneDetailPK;
import com.billng.numbering.service.PhoneDetailService;
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

import java.util.List;
import java.util.Optional;

@RequestMapping("/phone-detail")
@RestController
@Slf4j
@Api("phone-detail")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PhoneDetailController {
    private final PhoneDetailService phoneDetailService;

    public PhoneDetailController(PhoneDetailService phoneDetailService) {
        this.phoneDetailService = phoneDetailService;
    }

    @GetMapping("/findPhoneDetail/{assignRangeId}")
    public List<PhoneDetailDto> findByAssignedId(@PathVariable String assignRangeId){
        return phoneDetailService.findByAssignRangeId(assignRangeId);
    }

    @PostMapping("/updateServiceLocation")
    public ResponseEntity<Void> updateServiceLocation(@RequestBody PhoneDetailDto phoneDetailDto){
        phoneDetailService.updateServiceLocation(phoneDetailDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PhoneDetailDto phoneDetailDto) {
        phoneDetailService.save(phoneDetailDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDetailDto> findById(@PathVariable("id") PhoneDetailPK id) {
        PhoneDetailDto phoneDetail = phoneDetailService.findById(id);
        return ResponseEntity.ok(phoneDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") PhoneDetailPK id) {
        Optional.ofNullable(phoneDetailService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        phoneDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<PhoneDetailDto>> pageQuery(PhoneDetailDto phoneDetailDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PhoneDetailDto> phoneDetailPage = phoneDetailService.findByCondition(phoneDetailDto, pageable);
        return ResponseEntity.ok(phoneDetailPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PhoneDetailDto phoneDetailDto, @PathVariable("id") PhoneDetailPK id) {
        phoneDetailService.update(phoneDetailDto, id);
        return ResponseEntity.ok().build();
    }
}
