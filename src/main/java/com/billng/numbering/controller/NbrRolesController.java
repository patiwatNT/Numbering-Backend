package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrRolesDto;
import com.billng.numbering.dtoC.NbrRolePrivilege;
import com.billng.numbering.entities.NbrRoles;
import com.billng.numbering.mapper.NbrRolesMapper;
import com.billng.numbering.service.NbrRolesService;
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

@RequestMapping("/nbr-roles")
@RestController
@Slf4j
@Api("nbr-roles")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrRolesController {
    private final NbrRolesService nbrRolesService;

    public NbrRolesController(NbrRolesService nbrRolesService) {
        this.nbrRolesService = nbrRolesService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrRolesDto nbrRolesDto) {
        nbrRolesService.save(nbrRolesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll/{empCode}")
    public List<NbrRolePrivilege> findAll(@PathVariable("empCode") String empCode){
        return nbrRolesService.findAll(empCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrRolesDto> findById(@PathVariable("id") Integer id) {
        NbrRolesDto nbrRoles = nbrRolesService.findById(id);
        return ResponseEntity.ok(nbrRoles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(nbrRolesService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrRolesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrRolesDto>> pageQuery(NbrRolesDto nbrRolesDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrRolesDto> nbrRolesPage = nbrRolesService.findByCondition(nbrRolesDto, pageable);
        return ResponseEntity.ok(nbrRolesPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrRolesDto nbrRolesDto, @PathVariable("id") Integer id) {
        nbrRolesService.update(nbrRolesDto, id);
        return ResponseEntity.ok().build();
    }
}
