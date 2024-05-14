package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrUsersRolesDto;
import com.billng.numbering.entities.NbrUsersRoles;
import com.billng.numbering.mapper.NbrUsersRolesMapper;
import com.billng.numbering.service.NbrUsersRolesService;
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

@RequestMapping("/nbr-users-roles")
@RestController
@Slf4j
@Api("nbr-users-roles")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrUsersRolesController {
    private final NbrUsersRolesService nbrUsersRolesService;

    public NbrUsersRolesController(NbrUsersRolesService nbrUsersRolesService) {
        this.nbrUsersRolesService = nbrUsersRolesService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrUsersRolesDto nbrUsersRolesDto) {
        nbrUsersRolesService.save(nbrUsersRolesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrUsersRolesDto> findById(@PathVariable("id") String id) {
        NbrUsersRolesDto nbrUsersRoles = nbrUsersRolesService.findById(id);
        return ResponseEntity.ok(nbrUsersRoles);
    }

    @GetMapping("/findByEmpId/{id}")
    public NbrUsersRolesDto findByEmpId(@PathVariable("id") String empId) {
        return nbrUsersRolesService.findByEmpId(empId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(nbrUsersRolesService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrUsersRolesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrUsersRolesDto>> pageQuery(NbrUsersRolesDto nbrUsersRolesDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrUsersRolesDto> nbrUsersRolesPage = nbrUsersRolesService.findByCondition(nbrUsersRolesDto, pageable);
        return ResponseEntity.ok(nbrUsersRolesPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrUsersRolesDto nbrUsersRolesDto, @PathVariable("id") String id) {
        nbrUsersRolesService.update(nbrUsersRolesDto, id);
        return ResponseEntity.ok().build();
    }
}
