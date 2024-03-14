package com.billng.numbering.service;

import com.billng.numbering.dto.AssignedRangeDto;
import com.billng.numbering.dto.NumberingLocationDto;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.entities.AssignedRange;
import com.billng.numbering.mapper.AssignedRangeMapper;
import com.billng.numbering.repository.AssignedRangeRepository;
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
public class AssignedRangeService {
    private final AssignedRangeRepository repository;

    private final NumberingLocationService numberingLocationService;
    private final AssignedRangeMapper assignedRangeMapper;
    private final Map<String,String> locationMap = new HashMap<>();

    public AssignedRangeService(AssignedRangeRepository repository, NumberingLocationService numberingLocationService, AssignedRangeMapper assignedRangeMapper) {
        this.repository = repository;
        this.numberingLocationService = numberingLocationService;
        this.assignedRangeMapper = assignedRangeMapper;
    }

    public List<AssignedRangeDto> findByCriteria(AssignedRangeDtoC assignedRangeDtoC){
        log.info("{}",assignedRangeDtoC);
        String query = buildQuery(assignedRangeDtoC);
        List<AssignedRangeDto> assignedRangeDtoList = repository.findByCriteria(query);
        List<AssignedRangeDto> newAssignedRangeDtoList = new ArrayList<>();
        List<NumberingLocationDto> numberingLocationDtoList = numberingLocationService.findAllCustom();
        for(NumberingLocationDto temp: numberingLocationDtoList){
            locationMap.put(temp.getValue(),temp.getName());
        }
        for(AssignedRangeDto temp:assignedRangeDtoList){
            // Change Location
            String locationValue = temp.getLocation();
            if(locationMap.containsKey(locationValue)){
                String locationName = locationMap.get(locationValue);
                temp.setLocation(locationName);
            }
            newAssignedRangeDtoList.add(temp);
        }
        return newAssignedRangeDtoList;
    }

    public AssignedRangeDto save(AssignedRangeDto assignedRangeDto) {
        AssignedRange entity = assignedRangeMapper.toEntity(assignedRangeDto);
        return assignedRangeMapper.toDto(repository.save(entity));
    }

    public void deleteById(BigDecimal id) {
        repository.deleteById(id);
    }

    public AssignedRangeDto findById(BigDecimal id) {
        return assignedRangeMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<AssignedRangeDto> findByCondition(AssignedRangeDto assignedRangeDto, Pageable pageable) {
        Page<AssignedRange> entityPage = repository.findAll(pageable);
        List<AssignedRange> entities = entityPage.getContent();
        return new PageImpl<>(assignedRangeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public AssignedRangeDto update(AssignedRangeDto assignedRangeDto, BigDecimal id) {
        AssignedRangeDto data = findById(id);
        AssignedRange entity = assignedRangeMapper.toEntity(assignedRangeDto);
        //BeanUtil.copyProperties(data, entity);
        return save(assignedRangeMapper.toDto(entity));
    }

    private String buildQuery(AssignedRangeDtoC assignedRangeDtoC) {
        StringBuilder queryBuilder = new StringBuilder("1 = 1 AND ");

        addToQuery(queryBuilder, "phone_info", assignedRangeDtoC.getPhoneInfo());
        addToQuery(queryBuilder, "provider", assignedRangeDtoC.getProvider());
        addToQuery(queryBuilder, "division", assignedRangeDtoC.getDivision());
        addToQuery(queryBuilder, "location", assignedRangeDtoC.getLocation());
        addToQuery(queryBuilder, "block_id", assignedRangeDtoC.getBlockId());

        return StringUtils.removeEnd(queryBuilder.toString(), " AND ");
    }

    private void addToQuery(StringBuilder queryBuilder, String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            if (fieldName.equals("phone_info")) {
                queryBuilder.append(value).append(" BETWEEN SUBSTR(START_TEL,1," + value.length() + ") AND SUBSTR(END_TEL,1," + value.length() + ")").append(" AND ");
            } else {
                queryBuilder.append(fieldName).append(" = '").append(value).append("' AND ");
            }
        }
    }
}
