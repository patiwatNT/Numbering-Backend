package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingPrivilegesDto;
import com.billng.numbering.entities.NumberingPrivileges;
import com.billng.numbering.mapper.NumberingPrivilegesMapper;
import com.billng.numbering.repository.NumberingPrivilegesRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NumberingPrivilegesService {
    private final NumberingPrivilegesRepository repository;
    private final NumberingPrivilegesMapper numberingPrivilegesMapper;

    public NumberingPrivilegesService(NumberingPrivilegesRepository repository, NumberingPrivilegesMapper numberingPrivilegesMapper) {
        this.repository = repository;
        this.numberingPrivilegesMapper = numberingPrivilegesMapper;
    }

    public List<NumberingPrivilegesDto> findAll(){
        return numberingPrivilegesMapper.toDto(repository.findAll());
    }

    public NumberingPrivilegesDto save(NumberingPrivilegesDto numberingPrivilegesDto) {
        NumberingPrivileges entity = numberingPrivilegesMapper.toEntity(numberingPrivilegesDto);
        return numberingPrivilegesMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public NumberingPrivilegesDto findById(BigDecimal id) {
        return numberingPrivilegesMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingPrivilegesDto> findByCondition(NumberingPrivilegesDto numberingPrivilegesDto, Pageable pageable) {
        Page<NumberingPrivileges> entityPage = repository.findAll(pageable);
        List<NumberingPrivileges> entities = entityPage.getContent();
        return new PageImpl<>(numberingPrivilegesMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingPrivilegesDto update(NumberingPrivilegesDto numberingPrivilegesDto, BigDecimal id) {
        NumberingPrivilegesDto data = findById(id);
        NumberingPrivileges entity = numberingPrivilegesMapper.toEntity(numberingPrivilegesDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingPrivilegesMapper.toDto(entity));
    }
}
