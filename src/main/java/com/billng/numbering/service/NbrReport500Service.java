package com.billng.numbering.service;

import com.billng.numbering.dto.NbrReport500Dto;
import com.billng.numbering.entities.NbrReport500;
import com.billng.numbering.mapper.NbrReport500Mapper;
import com.billng.numbering.repository.NbrReport500Repository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NbrReport500Service {
    private final NbrReport500Repository repository;
    private final NbrReport500Mapper nbrReport500Mapper;

    public NbrReport500Service(NbrReport500Repository repository, NbrReport500Mapper nbrReport500Mapper) {
        this.repository = repository;
        this.nbrReport500Mapper = nbrReport500Mapper;
    }

    public List<NbrReport500Dto> findAll(){
        return nbrReport500Mapper.toDto(repository.findAll());
    }

    public List<NbrReport500Dto> findAllOnly(){
        return repository.findAllOnly();
    }

//    public NbrReport500Dto save(NbrReport500Dto nbrReport500Dto) {
//        NbrReport500 entity = nbrReport500Mapper.toEntity(nbrReport500Dto);
//        return nbrReport500Mapper.toDto(repository.save(entity));
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
//
//    public NbrReport500Dto findById(int id) {
//        return nbrReport500Mapper.toDto(repository.findById(id)
//                .orElseThrow(ResourceNotFoundException::new));
//    }
//
//    public Page<NbrReport500Dto> findByCondition(NbrReport500Dto nbrReport500Dto, Pageable pageable) {
//        Page<NbrReport500> entityPage = repository.findAll(pageable);
//        List<NbrReport500> entities = entityPage.getContent();
//        return new PageImpl<>(nbrReport500Mapper.toDto(entities), pageable, entityPage.getTotalElements());
//    }
//
//    public NbrReport500Dto update(NbrReport500Dto nbrReport500Dto, int id) {
//        NbrReport500Dto data = findById(id);
//        NbrReport500 entity = nbrReport500Mapper.toEntity(nbrReport500Dto);
//        BeanUtil.copyProperties(data, entity);
//        return save(nbrReport500Mapper.toDto(entity));
//    }
}
