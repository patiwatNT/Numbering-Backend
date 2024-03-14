package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.entities.NumberingLocation;
import com.billng.numbering.mapper.NumberingLocationMapper;
import com.billng.numbering.repository.NumberingLocationRepository;
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
public class NumberingLocationService {
    private final NumberingLocationRepository repository;
    private final NumberingLocationMapper numberingLocationMapper;

    public NumberingLocationService(NumberingLocationRepository repository, NumberingLocationMapper numberingLocationMapper) {
        this.repository = repository;
        this.numberingLocationMapper = numberingLocationMapper;
    }

    public List<NumberingLocationDto> findAllCustom(){
        return repository.findAllCustom();
    }

    public NumberingLocationDto save(NumberingLocationDto numberingLocationDto) {
        NumberingLocation entity = numberingLocationMapper.toEntity(numberingLocationDto);
        return numberingLocationMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public NumberingLocationDto findById(BigDecimal id) {
        return numberingLocationMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingLocationDto> findByCondition(NumberingLocationDto numberingLocationDto, Pageable pageable) {
        Page<NumberingLocation> entityPage = repository.findAll(pageable);
        List<NumberingLocation> entities = entityPage.getContent();
        return new PageImpl<>(numberingLocationMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingLocationDto update(NumberingLocationDto numberingLocationDto, BigDecimal id) {
        NumberingLocationDto data = findById(id);
        NumberingLocation entity = numberingLocationMapper.toEntity(numberingLocationDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingLocationMapper.toDto(entity));
    }
}
