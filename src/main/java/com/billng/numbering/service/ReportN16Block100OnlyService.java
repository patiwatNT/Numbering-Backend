package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block100OnlyDto;
import com.billng.numbering.entities.ReportN16Block100Only;
import com.billng.numbering.mapper.ReportN16Block100OnlyMapper;
import com.billng.numbering.repository.ReportN16Block100OnlyRepository;
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
public class ReportN16Block100OnlyService {
    private final ReportN16Block100OnlyRepository repository;
    private final ReportN16Block100OnlyMapper reportN16Block100OnlyMapper;

    public ReportN16Block100OnlyService(ReportN16Block100OnlyRepository repository, ReportN16Block100OnlyMapper reportN16Block100OnlyMapper) {
        this.repository = repository;
        this.reportN16Block100OnlyMapper = reportN16Block100OnlyMapper;
    }
    public List<ReportN16Block100OnlyDto> findAll(){
        return reportN16Block100OnlyMapper.toDto(repository.findAll());
    }
    public ReportN16Block100OnlyDto save(ReportN16Block100OnlyDto reportN16Block100OnlyDto) {
        ReportN16Block100Only entity = reportN16Block100OnlyMapper.toEntity(reportN16Block100OnlyDto);
        return reportN16Block100OnlyMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN16Block100OnlyDto findById(String id) {
        return reportN16Block100OnlyMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN16Block100OnlyDto> findByCondition(ReportN16Block100OnlyDto reportN16Block100OnlyDto, Pageable pageable) {
        Page<ReportN16Block100Only> entityPage = repository.findAll(pageable);
        List<ReportN16Block100Only> entities = entityPage.getContent();
        return new PageImpl<>(reportN16Block100OnlyMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN16Block100OnlyDto update(ReportN16Block100OnlyDto reportN16Block100OnlyDto, String id) {
        ReportN16Block100OnlyDto data = findById(id);
        ReportN16Block100Only entity = reportN16Block100OnlyMapper.toEntity(reportN16Block100OnlyDto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN16Block100OnlyMapper.toDto(entity));
    }
}
