package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN13Dto;
import com.billng.numbering.entities.ReportN13;
import com.billng.numbering.mapper.ReportN13Mapper;
import com.billng.numbering.repository.ReportN13Repository;
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
public class ReportN13Service {
    private final ReportN13Repository repository;
    private final ReportN13Mapper reportN13Mapper;

    public ReportN13Service(ReportN13Repository repository, ReportN13Mapper reportN13Mapper) {
        this.repository = repository;
        this.reportN13Mapper = reportN13Mapper;
    }

    public List<ReportN13Dto> findAll(){
        return reportN13Mapper.toDto(repository.findAll());
    }

    public ReportN13Dto save(ReportN13Dto reportN13Dto) {
        ReportN13 entity = reportN13Mapper.toEntity(reportN13Dto);
        return reportN13Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN13Dto findById(String id) {
        return reportN13Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN13Dto> findByCondition(ReportN13Dto reportN13Dto, Pageable pageable) {
        Page<ReportN13> entityPage = repository.findAll(pageable);
        List<ReportN13> entities = entityPage.getContent();
        return new PageImpl<>(reportN13Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN13Dto update(ReportN13Dto reportN13Dto, String id) {
        ReportN13Dto data = findById(id);
        ReportN13 entity = reportN13Mapper.toEntity(reportN13Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN13Mapper.toDto(entity));
    }
}
