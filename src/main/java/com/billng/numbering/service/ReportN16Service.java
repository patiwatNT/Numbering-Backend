package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN16Dto;
import com.billng.numbering.entities.ReportN16;
import com.billng.numbering.mapper.ReportN16Mapper;
import com.billng.numbering.repository.ReportN16Repository;
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
public class ReportN16Service {
    private final ReportN16Repository repository;
    private final ReportN16Mapper reportN16Mapper;

    public ReportN16Service(ReportN16Repository repository, ReportN16Mapper reportN16Mapper) {
        this.repository = repository;
        this.reportN16Mapper = reportN16Mapper;
    }

    public List<ReportN16Dto> findAll(){
        return reportN16Mapper.toDto(repository.findAll());
    }

    public ReportN16Dto save(ReportN16Dto reportN16Dto) {
        ReportN16 entity = reportN16Mapper.toEntity(reportN16Dto);
        return reportN16Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN16Dto findById(String id) {
        return reportN16Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN16Dto> findByCondition(ReportN16Dto reportN16Dto, Pageable pageable) {
        Page<ReportN16> entityPage = repository.findAll(pageable);
        List<ReportN16> entities = entityPage.getContent();
        return new PageImpl<>(reportN16Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN16Dto update(ReportN16Dto reportN16Dto, String id) {
        ReportN16Dto data = findById(id);
        ReportN16 entity = reportN16Mapper.toEntity(reportN16Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN16Mapper.toDto(entity));
    }
}
