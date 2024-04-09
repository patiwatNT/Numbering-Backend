package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.entities.NumberingRolePrivileges;
import com.billng.numbering.entities.NumberingRolePrivilegesPK;
import com.billng.numbering.mapper.NumberingRolePrivilegesMapper;
import com.billng.numbering.repository.NumberingRolePrivilegesRepository;
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
public class NumberingRolePrivilegesService {
    private final NumberingRolePrivilegesRepository repository;
    private final NumberingRolePrivilegesMapper numberingRolePrivilegesMapper;

    public NumberingRolePrivilegesService(NumberingRolePrivilegesRepository repository, NumberingRolePrivilegesMapper numberingRolePrivilegesMapper) {
        this.repository = repository;
        this.numberingRolePrivilegesMapper = numberingRolePrivilegesMapper;
    }

//    public NumberingRolePrivilegesDto save(NumberingRolePrivilegesDto numberingRolePrivilegesDto) {
//        NumberingRolePrivileges entity = numberingRolePrivilegesMapper.toEntity(numberingRolePrivilegesDto);
//        return numberingRolePrivilegesMapper.toDto(repository.save(entity));
//    }

//    public void deleteById(NumberingRolePrivilegesPK id) {
//        repository.deleteById(id);
//    }
//
//    public NumberingRolePrivilegesDto findById(NumberingRolePrivilegesPK id) {
//        return numberingRolePrivilegesMapper.toDto(repository.findById(id)
//                .orElseThrow(ResourceNotFoundException::new));
//    }

//    public Page<NumberingRolePrivilegesDto> findByCondition(NumberingRolePrivilegesDto numberingRolePrivilegesDto, Pageable pageable) {
//        Page<NumberingRolePrivileges> entityPage = repository.findAll(pageable);
//        List<NumberingRolePrivileges> entities = entityPage.getContent();
//        return new PageImpl<>(numberingRolePrivilegesMapper.toDto(entities), pageable, entityPage.getTotalElements());
//    }


}
