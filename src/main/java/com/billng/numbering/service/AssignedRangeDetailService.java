package com.billng.numbering.service;

import com.billng.numbering.dto.AssignedRangeDetailDto;
import com.billng.numbering.entities.AssignedRangeDetail;
import com.billng.numbering.entities.AssignedRangeDetailPK;
import com.billng.numbering.mapper.AssignedRangeDetailMapper;
import com.billng.numbering.repository.AssignedRangeDetailRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AssignedRangeDetailService {
    private final AssignedRangeDetailRepository repository;
    private final AssignedRangeDetailMapper assignedRangeDetailMapper;

    public AssignedRangeDetailService(AssignedRangeDetailRepository repository, AssignedRangeDetailMapper assignedRangeDetailMapper) {
        this.repository = repository;
        this.assignedRangeDetailMapper = assignedRangeDetailMapper;
    }

    public AssignedRangeDetailDto findByMainId(String id){
        return repository.findByMainId(id);
    }

    public AssignedRangeDetailDto save(AssignedRangeDetailDto assignedRangeDetailDto) {
        AssignedRangeDetail entity = assignedRangeDetailMapper.toEntity(assignedRangeDetailDto);
        return assignedRangeDetailMapper.toDto(repository.save(entity));
    }

    public void deleteById(AssignedRangeDetailPK id) {
        repository.deleteById(id);
    }

    public AssignedRangeDetailDto findById(AssignedRangeDetailPK id) {
        return assignedRangeDetailMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<AssignedRangeDetailDto> findByCondition(AssignedRangeDetailDto assignedRangeDetailDto, Pageable pageable) {
        Page<AssignedRangeDetail> entityPage = repository.findAll(pageable);
        List<AssignedRangeDetail> entities = entityPage.getContent();
        return new PageImpl<>(assignedRangeDetailMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public AssignedRangeDetailDto update(AssignedRangeDetailDto assignedRangeDetailDto, AssignedRangeDetailPK id) {
        AssignedRangeDetailDto data = findById(id);
        AssignedRangeDetail entity = assignedRangeDetailMapper.toEntity(assignedRangeDetailDto);
        //BeanUtil.copyProperties(data, entity);
        return save(assignedRangeDetailMapper.toDto(entity));
    }
}
