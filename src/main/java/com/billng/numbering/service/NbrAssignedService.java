package com.billng.numbering.service;

import com.billng.numbering.dto.*;
import com.billng.numbering.dtoC.AssignedRange;
import com.billng.numbering.dtoC.AssignedRangeDetail;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.NbrAssignedAmount;
import com.billng.numbering.entities.NbrAssigned;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repository.NbrAssignedRepository;
import com.billng.numbering.repository.NbrServiceNumbersRepository;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
@Transactional
public class NbrAssignedService {
    private final NbrAssignedRepository repository;
    private final NbrAssignedMapper nbrAssignedMapper;

    @Autowired
    private NbrServiceNumbersMapper nbrServiceNumbersMapper;

    @Autowired
    private NbrServiceNumbersRepository nbrServiceNumbersRepository;

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

    public String editAssignedRange(AssignedRange assignedRange) {
        String startTel = assignedRange.getBlockStart();
        String endTel = assignedRange.getBlockEnd();
        String serviceLocation = assignedRange.getSelectedLocation();
        int blockId = assignedRange.getBlockId();
        int providerId = assignedRange.getProviderId();
        String empCode = assignedRange.getEmpCode();
        int assignedId = assignedRange.getAssignedId();
        Date date = new Date();
        List<NbrServiceNumbersDto> newNbrServiceNumbersDtoList = nbrServiceNumbersRepository.findServiceNumberRange(startTel, endTel);
        List<NbrServiceNumbersDto> oldNbrServiceNumbersDtoList = nbrServiceNumbersRepository.findByAssignedId(assignedId);
        List<NbrServiceNumbersDto> tempList = new ArrayList<>();
        if (oldNbrServiceNumbersDtoList != null) {
            // Check New range is null
            for (NbrServiceNumbersDto obj : newNbrServiceNumbersDtoList) {
                if (!oldNbrServiceNumbersDtoList.contains(obj)) {
                    tempList.add(obj);
                    //newNbrServiceNumbersDtoList.remove(obj);
                }
            }
            boolean allNullAssignedId = tempList.stream()
                    .allMatch(obj -> obj.getAssignedId() == null);

            // Delete old range
            for(NbrServiceNumbersDto dto:oldNbrServiceNumbersDtoList){
                dto.setAssignedId(null);
                dto.setLocationCode(null);
                dto.setModifiedBy(empCode);
                dto.setLastModified(new Date());
            }
            nbrServiceNumbersRepository.saveAll(nbrServiceNumbersMapper.toEntity(oldNbrServiceNumbersDtoList));

            if (allNullAssignedId) {
                System.out.println("All Assigned is Null");
                // Update NBR_ASSIGNED
                NbrAssignedDto nbrAssignedDto = new NbrAssignedDto();
                nbrAssignedDto.setAssignedId(assignedId);
                nbrAssignedDto.setAssignedStart(startTel);
                nbrAssignedDto.setAssignedEnd(endTel);
                nbrAssignedDto.setAssignedQty((Integer.parseInt(endTel) - Integer.parseInt(startTel)) + 1);
                nbrAssignedDto.setAssignedLocationCode(serviceLocation);
                nbrAssignedDto.setBlockId(blockId);
                nbrAssignedDto.setProviderId(providerId);
                save(nbrAssignedDto);

                // Update location_code,assigned_id,modified_by,last_modified
                for (NbrServiceNumbersDto temp : newNbrServiceNumbersDtoList) {
                    temp.setAssignedId(assignedId);
                    temp.setLocationCode(serviceLocation);
                    temp.setModifiedBy(empCode);
                    temp.setLastModified(new Date());
                }
                nbrServiceNumbersRepository.saveAll(nbrServiceNumbersMapper.toEntity(newNbrServiceNumbersDtoList));

                //return "เพิ่มช่วง Assigned สำเร็จ";
                return "Success";
            } else {
                //return "หมายเลขในช่วง Assigned ใหม่มีการ Assigned ช่วงไปแล้ว";
                return "Failed";
            }
            // Delete assigned_id from old service_number in assignedRange

        } else {
            return null;
        }
    }

    public String editAssignedRangeDetail(AssignedRangeDetail assignedRangeDetail){
        int assignedId = assignedRangeDetail.getAssignedId();
        NbrAssignedDto nbrAssignedDto = repository.findByAssignedId(String.valueOf(assignedId));
        nbrAssignedDto.setAssignedDept(assignedRangeDetail.getAssignedDept());
        nbrAssignedDto.setAssignedRegion(assignedRangeDetail.getAssignedRegion());
        nbrAssignedDto.setAssignedSector(assignedRangeDetail.getAssignedSector());
        nbrAssignedDto.setDocRef(assignedRangeDetail.getDocRef());
        nbrAssignedDto.setProvince(assignedRangeDetail.getProvince());
        nbrAssignedDto.setServiceType(assignedRangeDetail.getServiceType());
        nbrAssignedDto.setStationAbbr(assignedRangeDetail.getStationAbbr());
        nbrAssignedDto.setStationCode(assignedRangeDetail.getStationCode());
        nbrAssignedDto.setStationCodeTtt(assignedRangeDetail.getStationCodeTtt());
        nbrAssignedDto.setStationNameEn(assignedRangeDetail.getStationNameEn());
        save(nbrAssignedDto);
        return "Success";
    }

    public String addAssignedRange(AssignedRange assignedRange) {
        String startTel = assignedRange.getBlockStart();
        String endTel = assignedRange.getBlockEnd();
        String serviceLocation = assignedRange.getSelectedLocation();
        int blockId = assignedRange.getBlockId();
        int providerId = assignedRange.getProviderId();
        String empCode = assignedRange.getEmpCode();
        List<NbrAssigned> nbrAssignedList = repository.findAll();
        int lastAssignedId = nbrAssignedList.getLast().getAssignedId() + 1;
        List<NbrServiceNumbersDto> nbrServiceNumberDtoList = nbrServiceNumbersRepository.findServiceNumberRange(startTel, endTel);
        if (nbrServiceNumberDtoList != null) {
            boolean allNullAssignedId = nbrServiceNumberDtoList.stream()
                    .allMatch(obj -> obj.getAssignedId() == null);
            if (allNullAssignedId) {
                System.out.println("All Assigned is Null");
                // Insert NBR_ASSIGNED
                NbrAssignedDto nbrAssignedDto = new NbrAssignedDto();
                nbrAssignedDto.setAssignedId(lastAssignedId);
                nbrAssignedDto.setAssignedStart(startTel);
                nbrAssignedDto.setAssignedEnd(endTel);
                nbrAssignedDto.setAssignedQty((Integer.parseInt(endTel) - Integer.parseInt(startTel)) + 1);
                nbrAssignedDto.setAssignedLocationCode(serviceLocation);
                nbrAssignedDto.setBlockId(blockId);
                nbrAssignedDto.setProviderId(providerId);
                save(nbrAssignedDto);

                // Update location_code,assigned_id,modified_by,last_modified
                for (NbrServiceNumbersDto temp : nbrServiceNumberDtoList) {
                    temp.setAssignedId(lastAssignedId);
                    temp.setLocationCode(serviceLocation);
                    temp.setModifiedBy(empCode);
                    temp.setLastModified(new Date());
                    nbrServiceNumbersRepository.save(nbrServiceNumbersMapper.toEntity(temp));
                }

                //return "เพิ่มช่วง Assigned สำเร็จ";
                return "Success";
            } else {
                //return "หมายเลขในช่วง Assigned ใหม่มีการ Assigned ช่วงไปแล้ว";
                return "Failed";
            }
        } else {
            return null;
        }
    }

    public List<NbrAssignedAmount> findAssignedAmount(AssignedRangeDtoC assignedRangeDtoC) {
        String query = buildQueryAmount(assignedRangeDtoC);
        return repository.findAssignedAmount(query);
    }

    public NbrAssignedDto findByAssignedId(String id) {
        if (!Objects.equals(id, "null")) {
            return repository.findByAssignedId(id);
        }
        return null;
    }

    public List<String> findAssignedRegion() {
        return repository.findAssignedRegion();
    }

    public List<String> findAssignedDept() {
        return repository.findAssignedDept();
    }

    public List<String> findAssignedSector() {
        return repository.findAssignedSector();
    }

    public List<NbrAssignedDto> findByCriteria(AssignedRangeDtoC assignedRangeDtoC) {
        log.info("{}", assignedRangeDtoC);
        String query = buildQuery(assignedRangeDtoC);
        List<NbrAssignedDto> nbrServiceNumberDtoList = repository.findByCriteria(query);
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
        return nbrServiceNumberDtoList;
    }

    public List<AssignedDto> findAllAssigned() {
        List<AssignedDto> assignedDtoList = new ArrayList<>();
        List<NbrProvidersDto> nbrProvidersDtoList = nbrProvidersService.findAll();
        for (int i = 0; i < nbrProvidersDtoList.size() - 1; i++) {
            AssignedDto assignedDto = new AssignedDto();
            assignedDto.setNo(BigDecimal.valueOf(i + 1));
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
