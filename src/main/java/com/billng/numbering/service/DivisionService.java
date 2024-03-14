package com.billng.numbering.service;

import com.billng.numbering.dto.DivisionDto;
import com.billng.numbering.entities.Division;
import com.billng.numbering.mapper.DivisionMapper;
import com.billng.numbering.repository.DivisionRepository;
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
public class DivisionService {
    private final DivisionRepository repository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository repository, DivisionMapper divisionMapper) {
        this.repository = repository;
        this.divisionMapper = divisionMapper;
    }

    public List<DivisionDto> findAll(){
        return divisionMapper.toDto(repository.findAll());
    }

    public DivisionDto save(DivisionDto divisionDto) {
        Division entity = divisionMapper.toEntity(divisionDto);
        return divisionMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public DivisionDto findById(BigDecimal id) {
        return divisionMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<DivisionDto> findByCondition(DivisionDto divisionDto, Pageable pageable) {
        Page<Division> entityPage = repository.findAll(pageable);
        List<Division> entities = entityPage.getContent();
        return new PageImpl<>(divisionMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DivisionDto update(DivisionDto divisionDto, BigDecimal id) {
        DivisionDto data = findById(id);
        Division entity = divisionMapper.toEntity(divisionDto);
        //BeanUtil.copyProperties(data, entity);
        return save(divisionMapper.toDto(entity));
    }
}
