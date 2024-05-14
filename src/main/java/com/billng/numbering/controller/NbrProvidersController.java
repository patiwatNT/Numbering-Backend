package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrProvidersDto;
import com.billng.numbering.entities.NbrProviders;
import com.billng.numbering.mapper.NbrProvidersMapper;
import com.billng.numbering.service.NbrProvidersService;
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

@RequestMapping("/nbr-providers")
@RestController
@Slf4j
@Api("nbr-providers")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class NbrProvidersController {
    private final NbrProvidersService nbrProvidersService;

    public NbrProvidersController(NbrProvidersService nbrProvidersService) {
        this.nbrProvidersService = nbrProvidersService;
    }

    @GetMapping("/findByProviderId/{id}")
    public NbrProvidersDto findByProviderId(@PathVariable("id") String id){
        return nbrProvidersService.findByProviderId(id);
    }

    @GetMapping("/findAll")
    public List<NbrProvidersDto> findAll(){
        return nbrProvidersService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrProvidersDto nbrProvidersDto) {
        nbrProvidersService.save(nbrProvidersDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrProvidersDto> findById(@PathVariable("id") Integer id) {
        NbrProvidersDto nbrProviders = nbrProvidersService.findById(id);
        return ResponseEntity.ok(nbrProviders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(nbrProvidersService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrProvidersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrProvidersDto>> pageQuery(NbrProvidersDto nbrProvidersDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrProvidersDto> nbrProvidersPage = nbrProvidersService.findByCondition(nbrProvidersDto, pageable);
        return ResponseEntity.ok(nbrProvidersPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrProvidersDto nbrProvidersDto, @PathVariable("id") Integer id) {
        nbrProvidersService.update(nbrProvidersDto, id);
        return ResponseEntity.ok().build();
    }
}
