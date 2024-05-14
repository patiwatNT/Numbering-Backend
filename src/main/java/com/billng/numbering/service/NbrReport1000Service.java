package com.billng.numbering.service;

import com.billng.numbering.dto.NbrReport1000Dto;
import com.billng.numbering.dtoC.NbrReportN16;
import com.billng.numbering.entities.NbrReport1000;
import com.billng.numbering.mapper.NbrReport1000Mapper;
import com.billng.numbering.repository.NbrReport1000Repository;
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
public class NbrReport1000Service {
    private final NbrReport1000Repository repository;
    private final NbrReport1000Mapper nbrReport1000Mapper;

    public NbrReport1000Service(NbrReport1000Repository repository, NbrReport1000Mapper nbrReport1000Mapper) {
        this.repository = repository;
        this.nbrReport1000Mapper = nbrReport1000Mapper;
    }

    public List<NbrReportN16> findReportN16Inc(){
        return repository.findReportN16Inc();
    }

    public List<NbrReportN16> findReportN16Only(){
        return repository.findReportN16Only();
    }

    public List<NbrReport1000Dto> findAll(){
        return nbrReport1000Mapper.toDto(repository.findAll());
    }

//    public NbrReport1000Dto save(NbrReport1000Dto nbrReport1000Dto) {
//        NbrReport1000 entity = nbrReport1000Mapper.toEntity(nbrReport1000Dto);
//        return nbrReport1000Mapper.toDto(repository.save(entity));
//    }
//
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
//
//    public NbrReport1000Dto findById(int id) {
//        return nbrReport1000Mapper.toDto(repository.findById(id)
//                .orElseThrow(ResourceNotFoundException::new));
//    }
//
//    public Page<NbrReport1000Dto> findByCondition(NbrReport1000Dto nbrReport1000Dto, Pageable pageable) {
//        Page<NbrReport1000> entityPage = repository.findAll(pageable);
//        List<NbrReport1000> entities = entityPage.getContent();
//        return new PageImpl<>(nbrReport1000Mapper.toDto(entities), pageable, entityPage.getTotalElements());
//    }
//
//    public NbrReport1000Dto update(NbrReport1000Dto nbrReport1000Dto, int id) {
//        NbrReport1000Dto data = findById(id);
//        NbrReport1000 entity = nbrReport1000Mapper.toEntity(nbrReport1000Dto);
//        BeanUtil.copyProperties(data, entity);
//        return save(nbrReport1000Mapper.toDto(entity));
//    }
}
