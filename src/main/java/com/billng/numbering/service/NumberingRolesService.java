package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingRolesDto;
import com.billng.numbering.entities.NumberingRoles;
import com.billng.numbering.mapper.NumberingRolesMapper;
import com.billng.numbering.repository.NumberingRolesRepository;
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
public class NumberingRolesService {
    private final NumberingRolesRepository repository;
    private final NumberingRolesMapper numberingRolesMapper;

    public NumberingRolesService(NumberingRolesRepository repository, NumberingRolesMapper numberingRolesMapper) {
        this.repository = repository;
        this.numberingRolesMapper = numberingRolesMapper;
    }

    public NumberingRolesDto save(NumberingRolesDto numberingRolesDto) {
        NumberingRoles entity = numberingRolesMapper.toEntity(numberingRolesDto);
        return numberingRolesMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public NumberingRolesDto findById(BigDecimal id) {
        return numberingRolesMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingRolesDto> findByCondition(NumberingRolesDto numberingRolesDto, Pageable pageable) {
        Page<NumberingRoles> entityPage = repository.findAll(pageable);
        List<NumberingRoles> entities = entityPage.getContent();
        return new PageImpl<>(numberingRolesMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingRolesDto update(NumberingRolesDto numberingRolesDto, BigDecimal id) {
        NumberingRolesDto data = findById(id);
        NumberingRoles entity = numberingRolesMapper.toEntity(numberingRolesDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingRolesMapper.toDto(entity));
    }
}
