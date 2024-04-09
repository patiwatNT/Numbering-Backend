package com.billng.numbering.service;

import com.billng.numbering.dto.ReportN16Block1000Dto;
import com.billng.numbering.dto.ReportN16Block500IncDto;
import com.billng.numbering.entities.ReportN16Block500Inc;
import com.billng.numbering.mapper.ReportN16Block500IncMapper;
import com.billng.numbering.repository.ReportN16Block500IncRepository;
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
public class ReportN16Block500IncService {
    private final ReportN16Block500IncRepository repository;
    private final ReportN16Block500IncMapper reportN16Block500IncMapper;

    public ReportN16Block500IncService(ReportN16Block500IncRepository repository, ReportN16Block500IncMapper reportN16Block500IncMapper) {
        this.repository = repository;
        this.reportN16Block500IncMapper = reportN16Block500IncMapper;
    }
    public List<ReportN16Block500IncDto> findAll(){
        return reportN16Block500IncMapper.toDto(repository.findAll());
    }
    public ReportN16Block500IncDto save(ReportN16Block500IncDto reportN16Block500IncDto) {
        ReportN16Block500Inc entity = reportN16Block500IncMapper.toEntity(reportN16Block500IncDto);
        return reportN16Block500IncMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ReportN16Block500IncDto findById(String id) {
        return reportN16Block500IncMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ReportN16Block500IncDto> findByCondition(ReportN16Block500IncDto reportN16Block500IncDto, Pageable pageable) {
        Page<ReportN16Block500Inc> entityPage = repository.findAll(pageable);
        List<ReportN16Block500Inc> entities = entityPage.getContent();
        return new PageImpl<>(reportN16Block500IncMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ReportN16Block500IncDto update(ReportN16Block500IncDto reportN16Block500IncDto, String id) {
        ReportN16Block500IncDto data = findById(id);
        ReportN16Block500Inc entity = reportN16Block500IncMapper.toEntity(reportN16Block500IncDto);
        //BeanUtil.copyProperties(data, entity);
        return save(reportN16Block500IncMapper.toDto(entity));
    }
}
