package com.billng.numbering.controller;

import com.billng.numbering.dto.ServiceCenterDto;
import com.billng.numbering.entities.ServiceCenter;
import com.billng.numbering.mapper.ServiceCenterMapper;
import com.billng.numbering.service.ServiceCenterService;
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

@RequestMapping("/service-center")
@RestController
@Slf4j
@Api("service-center")
public class ServiceCenterController {
    private final ServiceCenterService serviceCenterService;

    public ServiceCenterController(ServiceCenterService serviceCenterService) {
        this.serviceCenterService = serviceCenterService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ServiceCenterDto serviceCenterDto) {
        serviceCenterService.save(serviceCenterDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCenterDto> findById(@PathVariable("id") String id) {
        ServiceCenterDto serviceCenter = serviceCenterService.findById(id);
        return ResponseEntity.ok(serviceCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(serviceCenterService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        serviceCenterService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ServiceCenterDto>> pageQuery(ServiceCenterDto serviceCenterDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ServiceCenterDto> serviceCenterPage = serviceCenterService.findByCondition(serviceCenterDto, pageable);
        return ResponseEntity.ok(serviceCenterPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ServiceCenterDto serviceCenterDto, @PathVariable("id") String id) {
        serviceCenterService.update(serviceCenterDto, id);
        return ResponseEntity.ok().build();
    }
}
