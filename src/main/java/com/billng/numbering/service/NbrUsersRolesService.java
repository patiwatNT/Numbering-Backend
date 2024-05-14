package com.billng.numbering.service;

import com.billng.numbering.dto.NbrUsersRolesDto;
import com.billng.numbering.entities.NbrUsersRoles;
import com.billng.numbering.mapper.NbrUsersRolesMapper;
import com.billng.numbering.repository.NbrUsersRolesRepository;
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
public class NbrUsersRolesService {
    private final NbrUsersRolesRepository repository;
    private final NbrUsersRolesMapper nbrUsersRolesMapper;

    public NbrUsersRolesService(NbrUsersRolesRepository repository, NbrUsersRolesMapper nbrUsersRolesMapper) {
        this.repository = repository;
        this.nbrUsersRolesMapper = nbrUsersRolesMapper;
    }

    public NbrUsersRolesDto save(NbrUsersRolesDto nbrUsersRolesDto) {
        NbrUsersRoles entity = nbrUsersRolesMapper.toEntity(nbrUsersRolesDto);
        return nbrUsersRolesMapper.toDto(repository.save(entity));
    }

    public NbrUsersRolesDto findByEmpId(String empId){

        return repository.findByEmpId(empId);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NbrUsersRolesDto findById(String id) {
        return nbrUsersRolesMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrUsersRolesDto> findByCondition(NbrUsersRolesDto nbrUsersRolesDto, Pageable pageable) {
        Page<NbrUsersRoles> entityPage = repository.findAll(pageable);
        List<NbrUsersRoles> entities = entityPage.getContent();
        return new PageImpl<>(nbrUsersRolesMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrUsersRolesDto update(NbrUsersRolesDto nbrUsersRolesDto, String id) {
        NbrUsersRolesDto data = findById(id);
        NbrUsersRoles entity = nbrUsersRolesMapper.toEntity(nbrUsersRolesDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrUsersRolesMapper.toDto(entity));
    }
}
