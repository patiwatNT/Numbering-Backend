package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block500OnlyDto;
import com.billng.numbering.entities.ReportN16Block500Only;
import com.billng.numbering.mapper.ReportN16Block500OnlyMapper;
import com.billng.numbering.repository.ReportN16Block500OnlyRepository;
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
public class ReportN16Block500OnlyService {
    private final ReportN16Block500OnlyRepository repository;
    private final ReportN16Block500OnlyMapper reportN16Block500OnlyMapper;

    public ReportN16Block500OnlyService(ReportN16Block500OnlyRepository repository, ReportN16Block500OnlyMapper reportN16Block500OnlyMapper) {
        this.repository = repository;
        this.reportN16Block500OnlyMapper = reportN16Block500OnlyMapper;
    }
    public List<ReportN16Block500OnlyDto> findAll(){
        return reportN16Block500OnlyMapper.toDto(repository.findAll());
    }
    public ReportN16Block500OnlyDto save(ReportN16Block500OnlyDto reportN16Block500OnlyDto) {
        ReportN16Block500Only entity = reportN16Block500OnlyMapper.toEntity(reportN16Block500OnlyDto);
        return reportN16Block500OnlyMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN16Block500OnlyDto findById(String id) {
        return reportN16Block500OnlyMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN16Block500OnlyDto> findByCondition(ReportN16Block500OnlyDto reportN16Block500OnlyDto, Pageable pageable) {
        Page<ReportN16Block500Only> entityPage = repository.findAll(pageable);
        List<ReportN16Block500Only> entities = entityPage.getContent();
        return new PageImpl<>(reportN16Block500OnlyMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN16Block500OnlyDto update(ReportN16Block500OnlyDto reportN16Block500OnlyDto, String id) {
        ReportN16Block500OnlyDto data = findById(id);
        ReportN16Block500Only entity = reportN16Block500OnlyMapper.toEntity(reportN16Block500OnlyDto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN16Block500OnlyMapper.toDto(entity));
    }
}
