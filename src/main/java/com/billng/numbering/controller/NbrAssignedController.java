package com.billng.numbering.controller;

import com.billng.numbering.dto.AssignedDto;
import com.billng.numbering.dto.NbrAssignedDto;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.NbrAssignedAmount;
import com.billng.numbering.entities.NbrAssigned;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.service.NbrAssignedService;
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

@RequestMapping("/nbr-assigned")
@RestController
@Slf4j
@Api("nbr-assigned")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NbrAssignedController {
    private final NbrAssignedService nbrAssignedService;

    public NbrAssignedController(NbrAssignedService nbrAssignedService) {
        this.nbrAssignedService = nbrAssignedService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NbrAssignedDto nbrAssignedDto) {
        nbrAssignedService.save(nbrAssignedDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/findAssignedAmount")
    public List<NbrAssignedAmount> findAssignedAmount(@RequestBody AssignedRangeDtoC assignedRangeDtoC){
        return nbrAssignedService.findAssignedAmount(assignedRangeDtoC);
    }

    @GetMapping("/findByAssignedId/{id}")
    public NbrAssignedDto findByAssignedId(@PathVariable("id") String id){
        return nbrAssignedService.findByAssignedId(id);
    }

    @PostMapping("/findAssigned")
    public List<NbrAssignedDto> findByCriteria(@RequestBody @Validated AssignedRangeDtoC assignedRangeDtoC){
        return nbrAssignedService.findByCriteria(assignedRangeDtoC);
    }

    @GetMapping("/findAssignedRegion")
    public List<String> findAssignedRegion(){
        return nbrAssignedService.findAssignedRegion();
    }

    @GetMapping("/findAssignedSector")
    public List<String> findAssignedSector(){
        return nbrAssignedService.findAssignedSector();
    }

    @GetMapping("/findAllAssigned")
    public List<AssignedDto> findAllAssigned(){
        return nbrAssignedService.findAllAssigned();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NbrAssignedDto> findById(@PathVariable("id") Integer id) {
        NbrAssignedDto nbrAssigned = nbrAssignedService.findById(id);
        return ResponseEntity.ok(nbrAssigned);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(nbrAssignedService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        nbrAssignedService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NbrAssignedDto>> pageQuery(NbrAssignedDto nbrAssignedDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NbrAssignedDto> nbrAssignedPage = nbrAssignedService.findByCondition(nbrAssignedDto, pageable);
        return ResponseEntity.ok(nbrAssignedPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NbrAssignedDto nbrAssignedDto, @PathVariable("id") Integer id) {
        nbrAssignedService.update(nbrAssignedDto, id);
        return ResponseEntity.ok().build();
    }
}
