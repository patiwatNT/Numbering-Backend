package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.entities.NumberingRolePrivileges;
import com.billng.numbering.entities.NumberingRolePrivilegesPK;
import com.billng.numbering.mapper.NumberingRolePrivilegesMapper;
import com.billng.numbering.service.NumberingRolePrivilegesService;
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

@RequestMapping("/numbering-role-privileges")
@RestController
@Slf4j
@Api("numbering-role-privileges")
public class NumberingRolePrivilegesController {
    private final NumberingRolePrivilegesService numberingRolePrivilegesService;

    public NumberingRolePrivilegesController(NumberingRolePrivilegesService numberingRolePrivilegesService) {
        this.numberingRolePrivilegesService = numberingRolePrivilegesService;
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody @Validated NumberingRolePrivilegesDto numberingRolePrivilegesDto) {
//        numberingRolePrivilegesService.save(numberingRolePrivilegesDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NumberingRolePrivilegesDto> findById(@PathVariable("id") NumberingRolePrivilegesPK id) {
//        NumberingRolePrivilegesDto numberingRolePrivileges = numberingRolePrivilegesService.findById(id);
//        return ResponseEntity.ok(numberingRolePrivileges);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") NumberingRolePrivilegesPK id) {
//        Optional.ofNullable(numberingRolePrivilegesService.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data!");
//            return new ResourceNotFoundException();
//        });
//        numberingRolePrivilegesService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/page-query")
//    public ResponseEntity<Page<NumberingRolePrivilegesDto>> pageQuery(NumberingRolePrivilegesDto numberingRolePrivilegesDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<NumberingRolePrivilegesDto> numberingRolePrivilegesPage = numberingRolePrivilegesService.findByCondition(numberingRolePrivilegesDto, pageable);
//        return ResponseEntity.ok(numberingRolePrivilegesPage);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody @Validated NumberingRolePrivilegesDto numberingRolePrivilegesDto, @PathVariable("id") NumberingRolePrivilegesPK id) {
//        numberingRolePrivilegesService.update(numberingRolePrivilegesDto, id);
//        return ResponseEntity.ok().build();
//    }
}
