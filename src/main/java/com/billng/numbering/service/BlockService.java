package com.billng.numbering.service;

import com.billng.numbering.dto.BlockDto;
import com.billng.numbering.entities.Block;
import com.billng.numbering.mapper.BlockMapper;
import com.billng.numbering.repository.BlockRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BlockService {
    private final BlockRepository repository;
    private final BlockMapper blockMapper;

    public BlockService(BlockRepository repository, BlockMapper blockMapper) {
        this.repository = repository;
        this.blockMapper = blockMapper;
    }

    public List<BlockDto> findAll(){
        return blockMapper.toDto(repository.findAll());
    }

    public BlockDto save(BlockDto blockDto) {
        Block entity = blockMapper.toEntity(blockDto);
        return blockMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public BlockDto findById(BigDecimal id) {
        return blockMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<BlockDto> findByCondition(BlockDto blockDto, Pageable pageable) {
        Page<Block> entityPage = repository.findAll(pageable);
        List<Block> entities = entityPage.getContent();
        return new PageImpl<>(blockMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public BlockDto update(BlockDto blockDto, BigDecimal id) {
        BlockDto data = findById(id);
        Block entity = blockMapper.toEntity(blockDto);
        //BeanUtil.copyProperties(data, entity);
        return save(blockMapper.toDto(entity));
    }
}
