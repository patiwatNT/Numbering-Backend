package com.billng.numbering.service;

import com.billng.numbering.dto.NbrReport100Dto;
import com.billng.numbering.entities.NbrReport100;
import com.billng.numbering.mapper.NbrReport100Mapper;
import com.billng.numbering.repository.NbrReport100Repository;
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
public class NbrReport100Service {
    private final NbrReport100Repository repository;
    private final NbrReport100Mapper nbrReport100Mapper;

    public NbrReport100Service(NbrReport100Repository repository, NbrReport100Mapper nbrReport100Mapper) {
        this.repository = repository;
        this.nbrReport100Mapper = nbrReport100Mapper;
    }

    public List<NbrReport100Dto> findAll(){
        return nbrReport100Mapper.toDto(repository.findAll());
    }

    public List<NbrReport100Dto> findAllOnly(){
        return repository.findAllOnly();
    }

//    public NbrReport100Dto save(NbrReport100Dto nbrReport100Dto) {
//        NbrReport100 entity = nbrReport100Mapper.toEntity(nbrReport100Dto);
//        return nbrReport100Mapper.toDto(repository.save(entity));
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
//
//    public NbrReport100Dto findById(int id) {
//        return nbrReport100Mapper.toDto(repository.findById(id)
//                .orElseThrow(ResourceNotFoundException::new));
//    }
//
//    public Page<NbrReport100Dto> findByCondition(NbrReport100Dto nbrReport100Dto, Pageable pageable) {
//        Page<NbrReport100> entityPage = repository.findAll(pageable);
//        List<NbrReport100> entities = entityPage.getContent();
//        return new PageImpl<>(nbrReport100Mapper.toDto(entities), pageable, entityPage.getTotalElements());
//    }
//
//    public NbrReport100Dto update(NbrReport100Dto nbrReport100Dto, int id) {
//        NbrReport100Dto data = findById(id);
//        NbrReport100 entity = nbrReport100Mapper.toEntity(nbrReport100Dto);
//        BeanUtil.copyProperties(data, entity);
//        return save(nbrReport100Mapper.toDto(entity));
//    }
}
