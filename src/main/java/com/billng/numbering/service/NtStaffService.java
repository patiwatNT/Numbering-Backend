package com.billng.numbering.service;

import com.billng.numbering.dto.NtStaffDto;
import com.billng.numbering.entities.NtStaff;
import com.billng.numbering.mapper.NtStaffMapper;
import com.billng.numbering.repository.NtStaffRepository;
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
public class NtStaffService {
    private final NtStaffRepository repository;
    private final NtStaffMapper ntStaffMapper;

    public NtStaffService(NtStaffRepository repository, NtStaffMapper ntStaffMapper) {
        this.repository = repository;
        this.ntStaffMapper = ntStaffMapper;
    }

    public NtStaffDto save(NtStaffDto ntStaffDto) {
        NtStaff entity = ntStaffMapper.toEntity(ntStaffDto);
        return ntStaffMapper.toDto(repository.save(entity));
    }

    public NtStaffDto findByEmpCode(String empCode){
        return repository.findByEmpCode(empCode);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NtStaffDto findById(String id) {
        return ntStaffMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NtStaffDto> findByCondition(NtStaffDto ntStaffDto, Pageable pageable) {
        Page<NtStaff> entityPage = repository.findAll(pageable);
        List<NtStaff> entities = entityPage.getContent();
        return new PageImpl<>(ntStaffMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NtStaffDto update(NtStaffDto ntStaffDto, String id) {
        NtStaffDto data = findById(id);
        NtStaff entity = ntStaffMapper.toEntity(ntStaffDto);
        //BeanUtil.copyProperties(data, entity);
        return save(ntStaffMapper.toDto(entity));
    }
}
