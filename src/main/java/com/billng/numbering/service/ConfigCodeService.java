package com.billng.numbering.service;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.entities.ConfigCode;
import com.billng.numbering.mapper.ConfigCodeMapper;
import com.billng.numbering.repository.ConfigCodeRepository;
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
public class ConfigCodeService {
    private final ConfigCodeRepository repository;
    private final ConfigCodeMapper configCodeMapper;

    public ConfigCodeService(ConfigCodeRepository repository, ConfigCodeMapper configCodeMapper) {
        this.repository = repository;
        this.configCodeMapper = configCodeMapper;
    }

    public List<ConfigCodeDto> findByStatusGroup(String statusGroup){
        return repository.findByStatusGroup(statusGroup);
    }

    public List<ConfigCodeDto> findAll(){
        return configCodeMapper.toDto(repository.findAll());
    }

    public ConfigCodeDto save(ConfigCodeDto configCodeDto) {
        ConfigCode entity = configCodeMapper.toEntity(configCodeDto);
        return configCodeMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ConfigCodeDto findById(String id) {
        return configCodeMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ConfigCodeDto> findByCondition(ConfigCodeDto configCodeDto, Pageable pageable) {
        Page<ConfigCode> entityPage = repository.findAll(pageable);
        List<ConfigCode> entities = entityPage.getContent();
        return new PageImpl<>(configCodeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ConfigCodeDto update(ConfigCodeDto configCodeDto, String id) {
        ConfigCodeDto data = findById(id);
        ConfigCode entity = configCodeMapper.toEntity(configCodeDto);
        //BeanUtil.copyProperties(data, entity);
        return save(configCodeMapper.toDto(entity));
    }
}
