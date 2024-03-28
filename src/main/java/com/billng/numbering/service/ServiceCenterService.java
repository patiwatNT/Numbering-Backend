package com.billng.numbering.service;

import com.billng.numbering.dto.ServiceCenterDto;
import com.billng.numbering.entities.ServiceCenter;
import com.billng.numbering.mapper.ServiceCenterMapper;
import com.billng.numbering.repository.ServiceCenterRepository;
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
public class ServiceCenterService {
    private final ServiceCenterRepository repository;
    private final ServiceCenterMapper serviceCenterMapper;

    public List<ServiceCenterDto> findAll(){
        return serviceCenterMapper.toDto(repository.findAll());
    }

    public ServiceCenterService(ServiceCenterRepository repository, ServiceCenterMapper serviceCenterMapper) {
        this.repository = repository;
        this.serviceCenterMapper = serviceCenterMapper;
    }

    public ServiceCenterDto save(ServiceCenterDto serviceCenterDto) {
        ServiceCenter entity = serviceCenterMapper.toEntity(serviceCenterDto);
        return serviceCenterMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ServiceCenterDto findById(String id) {
        return serviceCenterMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ServiceCenterDto> findByCondition(ServiceCenterDto serviceCenterDto, Pageable pageable) {
        Page<ServiceCenter> entityPage = repository.findAll(pageable);
        List<ServiceCenter> entities = entityPage.getContent();
        return new PageImpl<>(serviceCenterMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ServiceCenterDto update(ServiceCenterDto serviceCenterDto, String id) {
        ServiceCenterDto data = findById(id);
        ServiceCenter entity = serviceCenterMapper.toEntity(serviceCenterDto);
        //BeanUtil.copyProperties(data, entity);
        return save(serviceCenterMapper.toDto(entity));
    }
}
