package com.billng.numbering.service;

import com.billng.numbering.dto.NbrCrmAssetDto;
import com.billng.numbering.entities.NbrCrmAsset;
import com.billng.numbering.mapper.NbrCrmAssetMapper;
import com.billng.numbering.repository.NbrCrmAssetRepository;
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
public class NbrCrmAssetService {
    private final NbrCrmAssetRepository repository;
    private final NbrCrmAssetMapper nbrCrmAssetMapper;

    public NbrCrmAssetService(NbrCrmAssetRepository repository, NbrCrmAssetMapper nbrCrmAssetMapper) {
        this.repository = repository;
        this.nbrCrmAssetMapper = nbrCrmAssetMapper;
    }

    public NbrCrmAssetDto save(NbrCrmAssetDto nbrCrmAssetDto) {
        NbrCrmAsset entity = nbrCrmAssetMapper.toEntity(nbrCrmAssetDto);
        return nbrCrmAssetMapper.toDto(repository.save(entity));
    }

    public NbrCrmAssetDto findByTelNo(String telNo){
        return repository.findByTelNo(telNo);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NbrCrmAssetDto findById(String id) {
        return nbrCrmAssetMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrCrmAssetDto> findByCondition(NbrCrmAssetDto nbrCrmAssetDto, Pageable pageable) {
        Page<NbrCrmAsset> entityPage = repository.findAll(pageable);
        List<NbrCrmAsset> entities = entityPage.getContent();
        return new PageImpl<>(nbrCrmAssetMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrCrmAssetDto update(NbrCrmAssetDto nbrCrmAssetDto, String id) {
        NbrCrmAssetDto data = findById(id);
        NbrCrmAsset entity = nbrCrmAssetMapper.toEntity(nbrCrmAssetDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrCrmAssetMapper.toDto(entity));
    }
}
