package com.billng.numbering.controller;

import com.billng.numbering.dto.NumberingUsersDto;
import com.billng.numbering.dtoC.NumberingUserDetail;
import com.billng.numbering.entities.NumberingUsers;
import com.billng.numbering.mapper.NumberingUsersMapper;
import com.billng.numbering.service.NumberingUsersService;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/numbering-users")
@RestController
@Slf4j
@Api("numbering-users")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NumberingUsersController {
    private final NumberingUsersService numberingUsersService;

    public NumberingUsersController(NumberingUsersService numberingUsersService) {
        this.numberingUsersService = numberingUsersService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated NumberingUsersDto numberingUsersDto) {
        numberingUsersService.save(numberingUsersDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findUserDetail/{username}")
    public NumberingUserDetail findUserDetail(@PathVariable("username") String username){
        return numberingUsersService.findUserDetail(username);
    }

    @GetMapping("/findByUsername/{username}")
    public NumberingUsersDto findByUsername(@PathVariable("username") String username){
        return numberingUsersService.findByUsername(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberingUsersDto> findById(@PathVariable("id") BigDecimal id) {
        NumberingUsersDto numberingUsers = numberingUsersService.findById(id);
        return ResponseEntity.ok(numberingUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") BigDecimal id) {
        Optional.ofNullable(numberingUsersService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        numberingUsersService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NumberingUsersDto>> pageQuery(NumberingUsersDto numberingUsersDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NumberingUsersDto> numberingUsersPage = numberingUsersService.findByCondition(numberingUsersDto, pageable);
        return ResponseEntity.ok(numberingUsersPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NumberingUsersDto numberingUsersDto, @PathVariable("id") BigDecimal id) {
        numberingUsersService.update(numberingUsersDto, id);
        return ResponseEntity.ok().build();
    }
}
