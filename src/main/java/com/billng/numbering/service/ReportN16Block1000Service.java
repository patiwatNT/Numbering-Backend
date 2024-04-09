package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.entities.ReportN16Block1000;
import com.billng.numbering.mapper.ReportN16Block1000Mapper;
import com.billng.numbering.repository.ReportN16Block1000Repository;
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
public class ReportN16Block1000Service {
    private final ReportN16Block1000Repository repository;
    private final ReportN16Block1000Mapper reportN16Block1000Mapper;

    public ReportN16Block1000Service(ReportN16Block1000Repository repository, ReportN16Block1000Mapper reportN16Block1000Mapper) {
        this.repository = repository;
        this.reportN16Block1000Mapper = reportN16Block1000Mapper;
    }

    public List<ReportN16Block1000Dto> findAll(){
        return reportN16Block1000Mapper.toDto(repository.findAll());
    }

    public ReportN16Block1000Dto save(ReportN16Block1000Dto reportN16Block1000Dto) {
        ReportN16Block1000 entity = reportN16Block1000Mapper.toEntity(reportN16Block1000Dto);
        return reportN16Block1000Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN16Block1000Dto findById(String id) {
        return reportN16Block1000Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN16Block1000Dto> findByCondition(ReportN16Block1000Dto reportN16Block1000Dto, Pageable pageable) {
        Page<ReportN16Block1000> entityPage = repository.findAll(pageable);
        List<ReportN16Block1000> entities = entityPage.getContent();
        return new PageImpl<>(reportN16Block1000Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN16Block1000Dto update(ReportN16Block1000Dto reportN16Block1000Dto, String id) {
        ReportN16Block1000Dto data = findById(id);
        ReportN16Block1000 entity = reportN16Block1000Mapper.toEntity(reportN16Block1000Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN16Block1000Mapper.toDto(entity));
    }
}
