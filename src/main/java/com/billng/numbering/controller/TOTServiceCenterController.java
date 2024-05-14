package com.billng.numbering.controller;

import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.dtoC.DropdownDto;
import com.billng.numbering.service.TOTServiceCenterService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tot-service-center")
@RestController
@Slf4j
@Api("tot-service-center")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TOTServiceCenterController {
    private final TOTServiceCenterService tOTServiceCenterService;

    public TOTServiceCenterController(TOTServiceCenterService tOTServiceCenterService) {
        this.tOTServiceCenterService = tOTServiceCenterService;
    }

    @GetMapping("findByLocationCode/{locationCode}")
    public TOTServiceCenterDto findByLocationCode(@PathVariable("locationCode") String locationCode){
        return tOTServiceCenterService.findByLocationCode(locationCode);
    }

    @GetMapping("/findServiceCenter")
    public List<DropdownDto> findServiceCenter(){
        return tOTServiceCenterService.findServiceCenter();
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody @Validated TOTServiceCenterDto tOTServiceCenterDto) {
//        tOTServiceCenterService.save(tOTServiceCenterDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TOTServiceCenterDto> findById(@PathVariable("id") String id) {
//        TOTServiceCenterDto tOTServiceCenter = tOTServiceCenterService.findById(id);
//        return ResponseEntity.ok(tOTServiceCenter);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
//        Optional.ofNullable(tOTServiceCenterService.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data!");
//            return new ResourceNotFoundException();
//        });
//        tOTServiceCenterService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/page-query")
//    public ResponseEntity<Page<TOTServiceCenterDto>> pageQuery(TOTServiceCenterDto tOTServiceCenterDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<TOTServiceCenterDto> tOTServiceCenterPage = tOTServiceCenterService.findByCondition(tOTServiceCenterDto, pageable);
//        return ResponseEntity.ok(tOTServiceCenterPage);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody @Validated TOTServiceCenterDto tOTServiceCenterDto, @PathVariable("id") String id) {
//        tOTServiceCenterService.update(tOTServiceCenterDto, id);
//        return ResponseEntity.ok().build();
//    }
}
