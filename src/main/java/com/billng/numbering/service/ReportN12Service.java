package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN12Dto;
import com.billng.numbering.entities.ReportN12;
import com.billng.numbering.mapper.ReportN12Mapper;
import com.billng.numbering.repository.ReportN12Repository;
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
public class ReportN12Service {
    private final ReportN12Repository repository;
    private final ReportN12Mapper reportN12Mapper;

    public ReportN12Service(ReportN12Repository repository, ReportN12Mapper reportN12Mapper) {
        this.repository = repository;
        this.reportN12Mapper = reportN12Mapper;
    }

    public List<ReportN12Dto> findAll(){
        return reportN12Mapper.toDto(repository.findAll());
    }

    public ReportN12Dto save(ReportN12Dto reportN12Dto) {
        ReportN12 entity = reportN12Mapper.toEntity(reportN12Dto);
        return reportN12Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN12Dto findById(String id) {
        return reportN12Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN12Dto> findByCondition(ReportN12Dto reportN12Dto, Pageable pageable) {
        Page<ReportN12> entityPage = repository.findAll(pageable);
        List<ReportN12> entities = entityPage.getContent();
        return new PageImpl<>(reportN12Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN12Dto update(ReportN12Dto reportN12Dto, String id) {
        ReportN12Dto data = findById(id);
        ReportN12 entity = reportN12Mapper.toEntity(reportN12Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN12Mapper.toDto(entity));
    }
}
