package com.billng.numbering.service;

import com.billng.numbering.dto.*;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.NbrAssignedAmount;
import com.billng.numbering.entities.NbrAssigned;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.repository.NbrAssignedRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NbrAssignedService {
    private final NbrAssignedRepository repository;
    private final NbrAssignedMapper nbrAssignedMapper;

    @Autowired
    private NbrProvidersService nbrProvidersService;

    public NbrAssignedService(NbrAssignedRepository repository, NbrAssignedMapper nbrAssignedMapper) {
        this.repository = repository;
        this.nbrAssignedMapper = nbrAssignedMapper;
    }

    public NbrAssignedDto save(NbrAssignedDto nbrAssignedDto) {
        NbrAssigned entity = nbrAssignedMapper.toEntity(nbrAssignedDto);
        return nbrAssignedMapper.toDto(repository.save(entity));
    }

    public List<NbrAssignedAmount> findAssignedAmount(AssignedRangeDtoC assignedRangeDtoC){
        String query = buildQueryAmount(assignedRangeDtoC);
        return repository.findAssignedAmount(query);
    }

    public NbrAssignedDto findByAssignedId(String id){
        if(!Objects.equals(id, "null")){
            return repository.findByAssignedId(id);
        }
        return null;
    }

    public List<String> findAssignedRegion(){
        return repository.findAssignedRegion();
    }

    public List<String> findAssignedSector(){
        return repository.findAssignedSector();
    }

    public List<NbrAssignedDto> findByCriteria(AssignedRangeDtoC assignedRangeDtoC){
        log.info("{}",assignedRangeDtoC);
        String query = buildQuery(assignedRangeDtoC);
        List<NbrAssignedDto> nbrAssignedDtoList = repository.findByCriteria(query);
//        for(NumberingLocationDto temp: numberingLocationDtoList){
//            locationMap.put(temp.getValue(),temp.getName());
//        }
//        for(AssignedRangeDto temp:assignedRangeDtoList){
//            // Change Location
//            String locationValue = temp.getLocation();
//            if(locationMap.containsKey(locationValue)){
//                String locationName = locationMap.get(locationValue);
//                temp.setLocation(locationName);
//            }
//            newAssignedRangeDtoList.add(temp);
//        }
        return nbrAssignedDtoList;
    }

    public List<AssignedDto> findAllAssigned(){
        List<AssignedDto> assignedDtoList = new ArrayList<>();
        List<NbrProvidersDto> nbrProvidersDtoList = nbrProvidersService.findAll();
        for(int i=0;i<nbrProvidersDtoList.size()-1;i++){
            AssignedDto assignedDto = new AssignedDto();
            assignedDto.setNo(BigDecimal.valueOf(i+1));
            assignedDto.setProvider(nbrProvidersDtoList.get(i).getProviderName());
            assignedDto.setProviderDescription(nbrProvidersDtoList.get(i).getProviderDesc());
            int countAssigned = repository.countAssignedByProviderId(nbrProvidersDtoList.get(i).getProviderId());
            assignedDto.setRangeAmount(BigInteger.valueOf(countAssigned));
            int sumAssigned = repository.sumAssignedQtyByProviderId(nbrProvidersDtoList.get(i).getProviderId());
            assignedDto.setTelAmount(BigInteger.valueOf(sumAssigned));
            assignedDtoList.add(assignedDto);
        }
        return assignedDtoList;
    }


    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NbrAssignedDto findById(Integer id) {
        return nbrAssignedMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrAssignedDto> findByCondition(NbrAssignedDto nbrAssignedDto, Pageable pageable) {
        Page<NbrAssigned> entityPage = repository.findAll(pageable);
        List<NbrAssigned> entities = entityPage.getContent();
        return new PageImpl<>(nbrAssignedMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrAssignedDto update(NbrAssignedDto nbrAssignedDto, Integer id) {
        NbrAssignedDto data = findById(id);
        NbrAssigned entity = nbrAssignedMapper.toEntity(nbrAssignedDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrAssignedMapper.toDto(entity));
    }

    private String buildQuery(AssignedRangeDtoC assignedRangeDtoC) {
        StringBuilder queryBuilder = new StringBuilder("1 = 1 AND ");

        addToQuery(queryBuilder, "phone_info", assignedRangeDtoC.getPhoneInfo());
        addToQuery(queryBuilder, "provider_id", assignedRangeDtoC.getProvider());
        addToQuery(queryBuilder, "assigned_sector", assignedRangeDtoC.getDivision());
        addToQuery(queryBuilder, "assigned_region", assignedRangeDtoC.getLocation());
        addToQuery(queryBuilder, "block_id", assignedRangeDtoC.getBlockId());

        return StringUtils.removeEnd(queryBuilder.toString(), " AND ");
    }

    private String buildQueryAmount(AssignedRangeDtoC assignedRangeDtoC) {
        StringBuilder queryBuilder = new StringBuilder("1 = 1 AND ");

        addToQuery(queryBuilder, "phone_info", assignedRangeDtoC.getPhoneInfo());
        addToQuery(queryBuilder, "A.provider_id", assignedRangeDtoC.getProvider());
        addToQuery(queryBuilder, "A.assigned_sector", assignedRangeDtoC.getDivision());
        addToQuery(queryBuilder, "A.assigned_region", assignedRangeDtoC.getLocation());
        addToQuery(queryBuilder, "A.block_id", assignedRangeDtoC.getBlockId());

        return StringUtils.removeEnd(queryBuilder.toString(), " AND ");
    }

    private void addToQuery(StringBuilder queryBuilder, String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            if (fieldName.equals("phone_info")) {
                queryBuilder.append(value).append(" BETWEEN SUBSTRING(assigned_start,1," + value.length() + ") AND SUBSTRING(assigned_end,1," + value.length() + ")").append(" AND ");
            } else {
                queryBuilder.append(fieldName).append(" = '").append(value).append("' AND ");
            }
        }
    }
}
