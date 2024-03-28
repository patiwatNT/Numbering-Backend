package com.billng.numbering.controller;

import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.dtoC.DropdownDto;
import com.billng.numbering.entities.ServiceLocation;
import com.billng.numbering.entities.ServiceLocationPK;
import com.billng.numbering.mapper.ServiceLocationMapper;
import com.billng.numbering.service.ServiceLocationService;
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

@RequestMapping("/service-location")
@RestController
@Slf4j
@Api("service-location")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ServiceLocationController {
    private final ServiceLocationService serviceLocationService;

    public ServiceLocationController(ServiceLocationService serviceLocationService) {
        this.serviceLocationService = serviceLocationService;
    }

    @GetMapping("/findAllServiceLocation")
    public List<DropdownDto> findAll(){
        return serviceLocationService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ServiceLocationDto serviceLocationDto) {
        serviceLocationService.save(serviceLocationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceLocationDto> findById(@PathVariable("id") ServiceLocationPK id) {
        ServiceLocationDto serviceLocation = serviceLocationService.findById(id);
        return ResponseEntity.ok(serviceLocation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") ServiceLocationPK id) {
        Optional.ofNullable(serviceLocationService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        serviceLocationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ServiceLocationDto>> pageQuery(ServiceLocationDto serviceLocationDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ServiceLocationDto> serviceLocationPage = serviceLocationService.findByCondition(serviceLocationDto, pageable);
        return ResponseEntity.ok(serviceLocationPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ServiceLocationDto serviceLocationDto, @PathVariable("id") ServiceLocationPK id) {
        serviceLocationService.update(serviceLocationDto, id);
        return ResponseEntity.ok().build();
    }
}
