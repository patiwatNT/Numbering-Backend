package com.billng.numbering.service;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.dto.ReportN11Dto;
import com.billng.numbering.entities.ReportN11;
import com.billng.numbering.mapper.ReportN11Mapper;
import com.billng.numbering.repository.ReportN11Repository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.*;

@Slf4j
@Service
@Transactional
public class ReportN11Service {
    private final ReportN11Repository repository;
    private final ReportN11Mapper reportN11Mapper;

    @Autowired
    private ConfigCodeService configCodeService;

    Map<String,String> configCodeMap = new HashMap<>();

    public ReportN11Service(ReportN11Repository repository, ReportN11Mapper reportN11Mapper) {
        this.repository = repository;
        this.reportN11Mapper = reportN11Mapper;
    }

    public List<ReportN11Dto> findAll(){
        return reportN11Mapper.toDto(repository.findAll());
    }

    public ReportN11Dto save(ReportN11Dto reportN11Dto) {
        ReportN11 entity = reportN11Mapper.toEntity(reportN11Dto);
        return reportN11Mapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN11Dto findById(String id) {
        return reportN11Mapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN11Dto> findByCondition(ReportN11Dto reportN11Dto, Pageable pageable) {
        Page<ReportN11> entityPage = repository.findAll(pageable);
        List<ReportN11> entities = entityPage.getContent();
        return new PageImpl<>(reportN11Mapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN11Dto update(ReportN11Dto reportN11Dto, String id) {
        ReportN11Dto data = findById(id);
        ReportN11 entity = reportN11Mapper.toEntity(reportN11Dto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN11Mapper.toDto(entity));
    }
}
