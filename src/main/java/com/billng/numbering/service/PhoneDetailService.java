package com.billng.numbering.service;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.dto.PhoneDetailDto;
import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.entities.PhoneDetail;
import com.billng.numbering.entities.PhoneDetailPK;
import com.billng.numbering.mapper.PhoneDetailMapper;
import com.billng.numbering.mapper.ServiceLocationMapper;
import com.billng.numbering.repository.PhoneDetailRepository;
import com.billng.numbering.repository.ServiceLocationRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.*;

@Slf4j
@Service
@Transactional
public class PhoneDetailService {
    private final PhoneDetailRepository repository;
    private final PhoneDetailMapper phoneDetailMapper;

    private Map<String,String> configcodeMap = new HashMap<>();

    private Map<String,String> serviceLocationMap = new HashMap<>();

    @Autowired
    private ConfigCodeService configCodeService;

    @Autowired
    private ServiceLocationService serviceLocationService;

    @Autowired
    private ServiceLocationRepository serviceLocationRepository;

    @Autowired
    private ServiceLocationMapper serviceLocationMapper;

    public PhoneDetailService(PhoneDetailRepository repository, PhoneDetailMapper phoneDetailMapper) {
        this.repository = repository;
        this.phoneDetailMapper = phoneDetailMapper;
    }

    public void updateServiceLocation(PhoneDetailDto phoneDetailDto){
        String serviceLocation = phoneDetailDto.getServiceLocation();
        String phoneNumber = phoneDetailDto.getPhoneNumber();
        log.info("{}",serviceLocation);
        log.info("{}",phoneNumber);
        repository.updateServiceLocation(phoneDetailDto);
    }

    public List<PhoneDetailDto> findByAssignRangeId(String assignRangeId){
        List<PhoneDetailDto> phoneDetailDtoList = repository.findByAssignRangeId(assignRangeId);
        List<ConfigCodeDto> configCodeDtoList = configCodeService.findByStatusGroup("WEB_CONFIG");
        List<ServiceLocationDto> serviceLocationDtoList = serviceLocationMapper.toDto(serviceLocationRepository.findAll());
        List<PhoneDetailDto> newPhoneDetailDtoList = new ArrayList<>();
        for(ConfigCodeDto temp:configCodeDtoList){
            configcodeMap.put(temp.getStatusCode(),temp.getStatusDescription());
        }
        for(ServiceLocationDto temp : serviceLocationDtoList){
            serviceLocationMap.put(temp.getServiceLocationPK().getServiceLocationId(), temp.getName());
        }
        for(PhoneDetailDto temp:phoneDetailDtoList){
            String crmStatus = temp.getCrmStatus();
            if(configcodeMap.containsKey(crmStatus)){
                temp.setCrmStatus(configcodeMap.get(crmStatus));

            }
            if(serviceLocationMap.containsKey(temp.getServiceLocation())){
                temp.setServiceLocation(temp.getServiceLocation()+" : "+ serviceLocationMap.get(temp.getServiceLocation()));
            }
            newPhoneDetailDtoList.add(temp);
        }

        return newPhoneDetailDtoList;
    }

    public PhoneDetailDto save(PhoneDetailDto phoneDetailDto) {
        PhoneDetail entity = phoneDetailMapper.toEntity(phoneDetailDto);
        return phoneDetailMapper.toDto(repository.save(entity));
    }

    public void deleteById(PhoneDetailPK id) {
        repository.deleteById(id);
    }

    public PhoneDetailDto findById(PhoneDetailPK id) {
        return phoneDetailMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<PhoneDetailDto> findByCondition(PhoneDetailDto phoneDetailDto, Pageable pageable) {
        Page<PhoneDetail> entityPage = repository.findAll(pageable);
        List<PhoneDetail> entities = entityPage.getContent();
        return new PageImpl<>(phoneDetailMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PhoneDetailDto update(PhoneDetailDto phoneDetailDto, PhoneDetailPK id) {
        PhoneDetailDto data = findById(id);
        PhoneDetail entity = phoneDetailMapper.toEntity(phoneDetailDto);
        //BeanUtil.copyProperties(data, entity);
        return save(phoneDetailMapper.toDto(entity));
    }
}
