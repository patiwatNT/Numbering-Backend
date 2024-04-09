package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingDataExportDto;
import com.billng.numbering.entities.NumberingDataExport;
import com.billng.numbering.mapper.NumberingDataExportMapper;
import com.billng.numbering.repository.NumberingDataExportRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NumberingDataExportService {
    private final NumberingDataExportRepository repository;
    private final NumberingDataExportMapper numberingDataExportMapper;

    public NumberingDataExportService(NumberingDataExportRepository repository, NumberingDataExportMapper numberingDataExportMapper) {
        this.repository = repository;
        this.numberingDataExportMapper = numberingDataExportMapper;
    }

    public List<NumberingDataExportDto> findAll(){
        return numberingDataExportMapper.toDto(repository.findAll());
    }

    public NumberingDataExportDto save(NumberingDataExportDto numberingDataExportDto) {
        NumberingDataExport entity = numberingDataExportMapper.toEntity(numberingDataExportDto);
        return numberingDataExportMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NumberingDataExportDto findById(String id) {
        return numberingDataExportMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingDataExportDto> findByCondition(NumberingDataExportDto numberingDataExportDto, Pageable pageable) {
        Page<NumberingDataExport> entityPage = repository.findAll(pageable);
        List<NumberingDataExport> entities = entityPage.getContent();
        return new PageImpl<>(numberingDataExportMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingDataExportDto update(NumberingDataExportDto numberingDataExportDto, String id) {
        NumberingDataExportDto data = findById(id);
        NumberingDataExport entity = numberingDataExportMapper.toEntity(numberingDataExportDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingDataExportMapper.toDto(entity));
    }
}
