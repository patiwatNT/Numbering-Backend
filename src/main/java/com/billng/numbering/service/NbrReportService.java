package com.billng.numbering.service;

import com.billng.numbering.dto.NbrReportDto;
import com.billng.numbering.entities.NbrReport;
import com.billng.numbering.mapper.NbrReportMapper;
import com.billng.numbering.repository.NbrReportRepository;
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
public class NbrReportService {
    private final NbrReportRepository repository;
    private final NbrReportMapper nbrReportMapper;

    public NbrReportService(NbrReportRepository repository, NbrReportMapper nbrReportMapper) {
        this.repository = repository;
        this.nbrReportMapper = nbrReportMapper;
    }

    public List<NbrReportDto> findAll(){
        return nbrReportMapper.toDto(repository.findAll());
    }

    public NbrReportDto save(NbrReportDto nbrReportDto) {
        NbrReport entity = nbrReportMapper.toEntity(nbrReportDto);
        return nbrReportMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NbrReportDto findById(String id) {
        return nbrReportMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrReportDto> findByCondition(NbrReportDto nbrReportDto, Pageable pageable) {
        Page<NbrReport> entityPage = repository.findAll(pageable);
        List<NbrReport> entities = entityPage.getContent();
        return new PageImpl<>(nbrReportMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrReportDto update(NbrReportDto nbrReportDto, String id) {
        NbrReportDto data = findById(id);
        NbrReport entity = nbrReportMapper.toEntity(nbrReportDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrReportMapper.toDto(entity));
    }
}
