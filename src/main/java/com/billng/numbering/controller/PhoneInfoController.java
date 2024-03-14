package com.billng.numbering.controller;

import com.billng.numbering.dto.PhoneInfoDto;
import com.billng.numbering.entities.PhoneInfo;
import com.billng.numbering.mapper.PhoneInfoMapper;
import com.billng.numbering.service.PhoneInfoService;
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

@RequestMapping("/phone-info")
@RestController
@Slf4j
@Api("phone-info")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhoneInfoController {
    private final PhoneInfoService phoneInfoService;

    public PhoneInfoController(PhoneInfoService phoneInfoService) {
        this.phoneInfoService = phoneInfoService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PhoneInfoDto phoneInfoDto) {
        phoneInfoService.save(phoneInfoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneInfoDto> findById(@PathVariable("id") String id) {
        PhoneInfoDto phoneInfo = phoneInfoService.findById(id);
        return ResponseEntity.ok(phoneInfo);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PhoneInfoDto> findByIdCustom(@PathVariable("id") String id) {
        PhoneInfoDto phoneInfo = phoneInfoService.findByIdCustom(id);
        return ResponseEntity.ok(phoneInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(phoneInfoService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        phoneInfoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<PhoneInfoDto>> pageQuery(PhoneInfoDto phoneInfoDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PhoneInfoDto> phoneInfoPage = phoneInfoService.findByCondition(phoneInfoDto, pageable);
        return ResponseEntity.ok(phoneInfoPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PhoneInfoDto phoneInfoDto, @PathVariable("id") String id) {
        phoneInfoService.update(phoneInfoDto, id);
        return ResponseEntity.ok().build();
    }
}
