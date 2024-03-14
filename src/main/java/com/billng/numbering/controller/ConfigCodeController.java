package com.billng.numbering.controller;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.entities.ConfigCode;
import com.billng.numbering.mapper.ConfigCodeMapper;
import com.billng.numbering.service.ConfigCodeService;
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

@RequestMapping("/config-code")
@RestController
@Slf4j
@Api("config-code")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ConfigCodeController {
    private final ConfigCodeService configCodeService;

    public ConfigCodeController(ConfigCodeService configCodeService) {
        this.configCodeService = configCodeService;
    }

    @GetMapping("/findByStatusGroup/{statusGroup}")
    public List<ConfigCodeDto> findByGroup(@PathVariable("statusGroup") String statusGroup){
        return configCodeService.findByStatusGroup(statusGroup);
    }

    @GetMapping("/findAll")
    public List<ConfigCodeDto> findAll(){
        return configCodeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ConfigCodeDto configCodeDto) {
        configCodeService.save(configCodeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigCodeDto> findById(@PathVariable("id") String id) {
        ConfigCodeDto configCode = configCodeService.findById(id);
        return ResponseEntity.ok(configCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(configCodeService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        configCodeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ConfigCodeDto>> pageQuery(ConfigCodeDto configCodeDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ConfigCodeDto> configCodePage = configCodeService.findByCondition(configCodeDto, pageable);
        return ResponseEntity.ok(configCodePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ConfigCodeDto configCodeDto, @PathVariable("id") String id) {
        configCodeService.update(configCodeDto, id);
        return ResponseEntity.ok().build();
    }
}
