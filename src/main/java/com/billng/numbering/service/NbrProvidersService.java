package com.billng.numbering.service;

import com.billng.numbering.dto.NbrProvidersDto;
import com.billng.numbering.entities.NbrProviders;
import com.billng.numbering.mapper.NbrProvidersMapper;
import com.billng.numbering.repository.NbrProvidersRepository;
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
public class NbrProvidersService {
    private final NbrProvidersRepository repository;
    private final NbrProvidersMapper nbrProvidersMapper;

    public NbrProvidersService(NbrProvidersRepository repository, NbrProvidersMapper nbrProvidersMapper) {
        this.repository = repository;
        this.nbrProvidersMapper = nbrProvidersMapper;
    }

    public NbrProvidersDto save(NbrProvidersDto nbrProvidersDto) {
        NbrProviders entity = nbrProvidersMapper.toEntity(nbrProvidersDto);
        return nbrProvidersMapper.toDto(repository.save(entity));
    }

    public List<NbrProvidersDto> findAll(){
        return nbrProvidersMapper.toDto(repository.findAll());
    }

    public NbrProvidersDto findByProviderId(String id){
        return repository.findByProviderId(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NbrProvidersDto findById(Integer id) {
        return nbrProvidersMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrProvidersDto> findByCondition(NbrProvidersDto nbrProvidersDto, Pageable pageable) {
        Page<NbrProviders> entityPage = repository.findAll(pageable);
        List<NbrProviders> entities = entityPage.getContent();
        return new PageImpl<>(nbrProvidersMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrProvidersDto update(NbrProvidersDto nbrProvidersDto, Integer id) {
        NbrProvidersDto data = findById(id);
        NbrProviders entity = nbrProvidersMapper.toEntity(nbrProvidersDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrProvidersMapper.toDto(entity));
    }
}
