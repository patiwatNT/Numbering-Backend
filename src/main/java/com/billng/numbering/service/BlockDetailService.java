package com.billng.numbering.service;

import com.billng.numbering.dto.BlockDetailDto;
import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.entities.BlockDetail;
import com.billng.numbering.mapper.BlockDetailMapper;
import com.billng.numbering.repository.BlockDetailRepository;
import com.billng.numbering.repository.ConfigCodeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
@Transactional
public class BlockDetailService {
    private final BlockDetailRepository repository;
    private final ConfigCodeService configCodeService;
    private final NumberingLocationService numberingLocationService;
    private final BlockDetailMapper blockDetailMapper;
    private final Map<String, String> statusCodeMap = new HashMap<>();
    private final Map<String,String> numberingLocationMap = new HashMap<>();

    public BlockDetailService(BlockDetailRepository repository, ConfigCodeService configCodeService, NumberingLocationService numberingLocationService, BlockDetailMapper blockDetailMapper) {
        this.repository = repository;
        this.configCodeService = configCodeService;
        this.numberingLocationService = numberingLocationService;
        this.blockDetailMapper = blockDetailMapper;
    }

    public List<BlockDetailDto> findByCriteria(BlockDetailDtoC blockDetailDtoC) {
        log.info("Obj C : {}", blockDetailDtoC);
        log.info("Service Start");
        String query = buildQuery(blockDetailDtoC);
        List<BlockDetailDto> newBlockDetailDtoList = new ArrayList<>();
        List<BlockDetailDto> blockDetailDtoList = repository.findByCriteria(query);
        List<ConfigCodeDto> configCodeDtoList = configCodeService.findAll();
        List<NumberingLocationDto> numberingLocationDtoList = numberingLocationService.findAllCustom();
        for (ConfigCodeDto temp : configCodeDtoList) {
            statusCodeMap.put(temp.getStatusCode(), temp.getStatusDescription());
        }
        for(NumberingLocationDto temp: numberingLocationDtoList){
            numberingLocationMap.put(temp.getValue(),temp.getName());
        }
        for (BlockDetailDto temp : blockDetailDtoList) {
            // Change Status Code to Status Description
            String statusCode = temp.getBlockStatus();
            if (statusCodeMap.containsKey(statusCode)) {
                String statusDescription = statusCodeMap.get(statusCode);
                temp.setBlockStatus(statusDescription);
            }
            // Change Location Value to Location Name
            String locationValue = temp.getLocation();
            if(numberingLocationMap.containsKey(locationValue)){
                String locationName = numberingLocationMap.get(locationValue);
                temp.setLocation(locationName);
            }
            newBlockDetailDtoList.add(temp);
        }
        return newBlockDetailDtoList;
    }

    public BlockDetailDto save(BlockDetailDto blockDetailDto) {
        BlockDetail entity = blockDetailMapper.toEntity(blockDetailDto);
        return blockDetailMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public BlockDetailDto findById(BigDecimal id) {
        return blockDetailMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<BlockDetailDto> findByCondition(BlockDetailDto blockDetailDto, Pageable pageable) {
        Page<BlockDetail> entityPage = repository.findAll(pageable);
        List<BlockDetail> entities = entityPage.getContent();
        return new PageImpl<>(blockDetailMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public BlockDetailDto update(BlockDetailDto blockDetailDto, BigDecimal id) {
        BlockDetailDto data = findById(id);
        BlockDetail entity = blockDetailMapper.toEntity(blockDetailDto);
        //BeanUtil.copyProperties(data, entity);
        return save(blockDetailMapper.toDto(entity));
    }

    private String buildQuery(BlockDetailDtoC blockDetailDtoC) {
        StringBuilder queryBuilder = new StringBuilder("1 = 1 AND ");

        addToQuery(queryBuilder, "phone_info", blockDetailDtoC.getPhoneNumber());
        addToQuery(queryBuilder, "provider", blockDetailDtoC.getProvider());
        addToQuery(queryBuilder, "block_status", blockDetailDtoC.getBlockStatus());
        addToQuery(queryBuilder, "location", blockDetailDtoC.getLocation());

        return StringUtils.removeEnd(queryBuilder.toString(), " AND ");
    }

    private void addToQuery(StringBuilder queryBuilder, String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            if (fieldName.equals("phone_info")) {
                queryBuilder.append(value).append(" BETWEEN SUBSTR(BLOCK_START,1," + value.length() + ") AND SUBSTR(BLOCK_END,1," + value.length() + ")").append(" AND ");
            } else {
                queryBuilder.append(fieldName).append(" = '").append(value).append("' AND ");
            }
        }
    }
}
