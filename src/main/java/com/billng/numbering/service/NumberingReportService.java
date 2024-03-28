package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingReportDto;
import com.billng.numbering.entities.NumberingReport;
import com.billng.numbering.mapper.NumberingReportMapper;
import com.billng.numbering.repository.NumberingReportRepository;
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
public class NumberingReportService {
    private final NumberingReportRepository repository;
    private final NumberingReportMapper numberingReportMapper;

    public NumberingReportService(NumberingReportRepository repository, NumberingReportMapper numberingReportMapper) {
        this.repository = repository;
        this.numberingReportMapper = numberingReportMapper;
    }

    public List<NumberingReportDto> findAll(){
        return numberingReportMapper.toDto(repository.findAll());
    }

    public NumberingReportDto save(NumberingReportDto numberingReportDto) {
        NumberingReport entity = numberingReportMapper.toEntity(numberingReportDto);
        return numberingReportMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NumberingReportDto findById(String id) {
        return numberingReportMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingReportDto> findByCondition(NumberingReportDto numberingReportDto, Pageable pageable) {
        Page<NumberingReport> entityPage = repository.findAll(pageable);
        List<NumberingReport> entities = entityPage.getContent();
        return new PageImpl<>(numberingReportMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingReportDto update(NumberingReportDto numberingReportDto, String id) {
        NumberingReportDto data = findById(id);
        NumberingReport entity = numberingReportMapper.toEntity(numberingReportDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingReportMapper.toDto(entity));
    }
}
