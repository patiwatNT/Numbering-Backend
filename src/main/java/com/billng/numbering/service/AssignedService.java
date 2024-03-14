package com.billng.numbering.service;

import com.billng.numbering.dto.AssignedDto;
import com.billng.numbering.entities.Assigned;
import com.billng.numbering.mapper.AssignedMapper;
import com.billng.numbering.repository.AssignedRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AssignedService {
    private final AssignedRepository repository;
    private final AssignedMapper assignedMapper;

    public AssignedService(AssignedRepository repository, AssignedMapper assignedMapper) {
        this.repository = repository;
        this.assignedMapper = assignedMapper;
    }

    public List<AssignedDto> findAll(){
        return assignedMapper.toDto(repository.findAll());
    }

    public AssignedDto save(AssignedDto assignedDto) {
        Assigned entity = assignedMapper.toEntity(assignedDto);
        return assignedMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public AssignedDto findById(BigDecimal id) {
        return assignedMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<AssignedDto> findByCondition(AssignedDto assignedDto, Pageable pageable) {
        Page<Assigned> entityPage = repository.findAll(pageable);
        List<Assigned> entities = entityPage.getContent();
        return new PageImpl<>(assignedMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public AssignedDto update(AssignedDto assignedDto, BigDecimal id) {
        AssignedDto data = findById(id);
        Assigned entity = assignedMapper.toEntity(assignedDto);
        //BeanUtil.copyProperties(data, entity);
        return save(assignedMapper.toDto(entity));
    }
}
