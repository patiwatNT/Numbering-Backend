package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN15Dto;
import com.billng.numbering.entities.ReportN15;
import com.billng.numbering.mapper.ReportN15Mapper;
import com.billng.numbering.repository.ReportN15Repository;
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
public class ReportN15Service {
    private final ReportN15Repository repository;
    private final ReportN15Mapper reportN15Mapper;

    public ReportN15Service(ReportN15Repository repository, ReportN15Mapper reportN15Mapper) {
        this.repository = repository;
        this.reportN15Mapper = reportN15Mapper;
    }

    public List<ReportN15Dto> findAll(){
        return reportN15Mapper.toDto(repository.findAll());
    }

    public ReportN15Dto save(ReportN15Dto reportN15Dto) {
        ReportN15 entity = reportN15Mapper.toEntity(reportN15Dto);
        return reportN15Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN15Dto findById(String id) {
        return reportN15Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN15Dto> findByCondition(ReportN15Dto reportN15Dto, Pageable pageable) {
        Page<ReportN15> entityPage = repository.findAll(pageable);
        List<ReportN15> entities = entityPage.getContent();
        return new PageImpl<>(reportN15Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN15Dto update(ReportN15Dto reportN15Dto, String id) {
        ReportN15Dto data = findById(id);
        ReportN15 entity = reportN15Mapper.toEntity(reportN15Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN15Mapper.toDto(entity));
    }
}
