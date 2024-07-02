package com.billng.numbering.service;

import com.billng.numbering.dto.NbrReserveDto;
import com.billng.numbering.entities.NbrReserve;
import com.billng.numbering.mapper.NbrReserveMapper;
import com.billng.numbering.repository.NbrReserveRepository;
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
public class NbrReserveService {
    private final NbrReserveRepository repository;
    private final NbrReserveMapper nbrReserveMapper;

    public NbrReserveService(NbrReserveRepository repository, NbrReserveMapper nbrReserveMapper) {
        this.repository = repository;
        this.nbrReserveMapper = nbrReserveMapper;
    }

    public NbrReserveDto save(NbrReserveDto nbrReserveDto) {
        NbrReserve entity = nbrReserveMapper.toEntity(nbrReserveDto);
        return nbrReserveMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public NbrReserveDto findById(Long id) {
        return nbrReserveMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrReserveDto> findByCondition(NbrReserveDto nbrReserveDto, Pageable pageable) {
        Page<NbrReserve> entityPage = repository.findAll(pageable);
        List<NbrReserve> entities = entityPage.getContent();
        return new PageImpl<>(nbrReserveMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrReserveDto update(NbrReserveDto nbrReserveDto, Long id) {
        NbrReserveDto data = findById(id);
        NbrReserve entity = nbrReserveMapper.toEntity(nbrReserveDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrReserveMapper.toDto(entity));
    }
}
