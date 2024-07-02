package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrReserveDto;
import com.billng.numbering.entities.NbrReserve;
import com.billng.numbering.mapper.NbrReserveMapper;
import com.billng.numbering.service.NbrReserveService;
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

@RequestMapping("/nbr-reserve")
@RestController
@Slf4j
@Api("nbr-reserve")
public class NbrReserveController {
    private final NbrReserveService nbrReserveService;

    public NbrReserveController(NbrReserveService nbrReserveService) {
        this.nbrReserveService = nbrReserveService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrReserveDto nbrReserveDto) {
        nbrReserveService.save(nbrReserveDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrReserveDto> findById(@PathVariable("id") Long id) {
        NbrReserveDto nbrReserve = nbrReserveService.findById(id);
        return ResponseEntity.ok(nbrReserve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional.ofNullable(nbrReserveService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrReserveService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrReserveDto>> pageQuery(NbrReserveDto nbrReserveDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrReserveDto> nbrReservePage = nbrReserveService.findByCondition(nbrReserveDto, pageable);
        return ResponseEntity.ok(nbrReservePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrReserveDto nbrReserveDto, @PathVariable("id") Long id) {
        nbrReserveService.update(nbrReserveDto, id);
        return ResponseEntity.ok().build();
    }
}
