package com.billng.numbering.service;

import com.billng.numbering.dto.PhoneInfoDto;
import com.billng.numbering.entities.PhoneInfo;
import com.billng.numbering.mapper.PhoneInfoMapper;
import com.billng.numbering.repository.PhoneInfoRepository;
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
public class PhoneInfoService {
    private final PhoneInfoRepository repository;
    private final PhoneInfoMapper phoneInfoMapper;

    public PhoneInfoService(PhoneInfoRepository repository, PhoneInfoMapper phoneInfoMapper) {
        this.repository = repository;
        this.phoneInfoMapper = phoneInfoMapper;
    }

    public PhoneInfoDto findByIdCustom(String id){
        return repository.findByIdCustom(id);
    }

    public PhoneInfoDto save(PhoneInfoDto phoneInfoDto) {
        PhoneInfo entity = phoneInfoMapper.toEntity(phoneInfoDto);
        return phoneInfoMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public PhoneInfoDto findById(String id) {
        return phoneInfoMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<PhoneInfoDto> findByCondition(PhoneInfoDto phoneInfoDto, Pageable pageable) {
        Page<PhoneInfo> entityPage = repository.findAll(pageable);
        List<PhoneInfo> entities = entityPage.getContent();
        return new PageImpl<>(phoneInfoMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PhoneInfoDto update(PhoneInfoDto phoneInfoDto, String id) {
        PhoneInfoDto data = findById(id);
        PhoneInfo entity = phoneInfoMapper.toEntity(phoneInfoDto);
        //BeanUtil.copyProperties(data, entity);
        return save(phoneInfoMapper.toDto(entity));
    }
}
