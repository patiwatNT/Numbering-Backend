package com.billng.numbering.service;

import com.billng.numbering.dto.NbrProductTypeDto;
import com.billng.numbering.entities.NbrProductType;
import com.billng.numbering.mapper.NbrProductTypeMapper;
import com.billng.numbering.repository.NbrProductTypeRepository;
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
public class NbrProductTypeService {
    private final NbrProductTypeRepository repository;
    private final NbrProductTypeMapper nbrProductTypeMapper;

    public NbrProductTypeService(NbrProductTypeRepository repository, NbrProductTypeMapper nbrProductTypeMapper) {
        this.repository = repository;
        this.nbrProductTypeMapper = nbrProductTypeMapper;
    }

    public NbrProductTypeDto save(NbrProductTypeDto nbrProductTypeDto) {
        NbrProductType entity = nbrProductTypeMapper.toEntity(nbrProductTypeDto);
        return nbrProductTypeMapper.toDto(repository.save(entity));
    }

    public List<String> findAll(){
        return repository.findAllProduct();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NbrProductTypeDto findById(Integer id) {
        return nbrProductTypeMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrProductTypeDto> findByCondition(NbrProductTypeDto nbrProductTypeDto, Pageable pageable) {
        Page<NbrProductType> entityPage = repository.findAll(pageable);
        List<NbrProductType> entities = entityPage.getContent();
        return new PageImpl<>(nbrProductTypeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrProductTypeDto update(NbrProductTypeDto nbrProductTypeDto, Integer id) {
        NbrProductTypeDto data = findById(id);
        NbrProductType entity = nbrProductTypeMapper.toEntity(nbrProductTypeDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrProductTypeMapper.toDto(entity));
    }
}
