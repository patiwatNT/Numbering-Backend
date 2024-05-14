package com.billng.numbering.controller;

import com.billng.numbering.dto.NbrServiceNumbersDto;
import com.billng.numbering.entities.NbrServiceNumbers;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.service.NbrServiceNumbersService;
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

@RequestMapping("/nbr-service-numbers")
@RestController
@Slf4j
@Api("nbr-service-numbers")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrServiceNumbersController {
    private final NbrServiceNumbersService nbrServiceNumbersService;

    public NbrServiceNumbersController(NbrServiceNumbersService nbrServiceNumbersService) {
        this.nbrServiceNumbersService = nbrServiceNumbersService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrServiceNumbersDto nbrServiceNumbersDto) {
        nbrServiceNumbersService.save(nbrServiceNumbersDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByAssignedId/{assignedId}")
    public List<NbrServiceNumbersDto> findByAssignedId(@PathVariable("assignedId") int id){
        return nbrServiceNumbersService.findByAssignedId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrServiceNumbersDto> findById(@PathVariable("id") String id) {
        NbrServiceNumbersDto nbrServiceNumbers = nbrServiceNumbersService.findById(id);
        return ResponseEntity.ok(nbrServiceNumbers);
    }

    @PostMapping("/updateServiceLocation")
    public ResponseEntity<Void> updateServiceLocation(@RequestBody NbrServiceNumbersDto nbrServiceNumbersDto){
        nbrServiceNumbersService.updateServiceLocation(nbrServiceNumbersDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByServiceNo/{serviceNo}")
    public NbrServiceNumbersDto findByServiceNo(@PathVariable("serviceNo") String serviceNo){
        return nbrServiceNumbersService.findByServiceNo(serviceNo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(nbrServiceNumbersService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrServiceNumbersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrServiceNumbersDto>> pageQuery(NbrServiceNumbersDto nbrServiceNumbersDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrServiceNumbersDto> nbrServiceNumbersPage = nbrServiceNumbersService.findByCondition(nbrServiceNumbersDto, pageable);
        return ResponseEntity.ok(nbrServiceNumbersPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrServiceNumbersDto nbrServiceNumbersDto, @PathVariable("id") String id) {
        nbrServiceNumbersService.update(nbrServiceNumbersDto, id);
        return ResponseEntity.ok().build();
    }
}
