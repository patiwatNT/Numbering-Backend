package com.billng.numbering.service;

import com.billng.numbering.dto.ServiceCenterDto;
import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.dtoC.DropdownDto;
import com.billng.numbering.dtoC.ItemGroup;
import com.billng.numbering.entities.ServiceCenter;
import com.billng.numbering.entities.ServiceLocation;
import com.billng.numbering.entities.ServiceLocationPK;
import com.billng.numbering.mapper.ServiceLocationMapper;
import com.billng.numbering.repository.ServiceLocationRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ServiceLocationService {
    private final ServiceLocationRepository repository;
    private final ServiceLocationMapper serviceLocationMapper;
    @Autowired
    private ServiceCenterService serviceCenterService;

    public ServiceLocationService(ServiceLocationRepository repository, ServiceLocationMapper serviceLocationMapper) {
        this.repository = repository;
        this.serviceLocationMapper = serviceLocationMapper;
    }

    public List<DropdownDto> findAll(){
        List<ServiceCenterDto> serviceCenterDtoList = serviceCenterService.findAll();
        List<ServiceLocationDto> serviceLocationDtoList = serviceLocationMapper.toDto(repository.findAll());
        List<DropdownDto> dropdownDtoList = new ArrayList<>();
        for(ServiceCenterDto centerTemp: serviceCenterDtoList){
            DropdownDto dropdownDto = new DropdownDto();
            dropdownDto.setLabel(centerTemp.getLocation());
            dropdownDto.setValue(centerTemp.getId());
            dropdownDto.setItems(new ArrayList<>());
            for(ServiceLocationDto locationTemp : serviceLocationDtoList){
                if(dropdownDto.getValue().equals(locationTemp.getServiceLocationPK().getServiceCenterId())){
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setLabel(locationTemp.getName());
                    itemGroup.setValue(locationTemp.getServiceLocationPK().getServiceLocationId());
                    dropdownDto.getItems().add(itemGroup);
                }
            }
            dropdownDtoList.add(dropdownDto);
        }

        return  dropdownDtoList;
    }

    public ServiceLocationDto save(ServiceLocationDto serviceLocationDto) {
        ServiceLocation entity = serviceLocationMapper.toEntity(serviceLocationDto);
        return serviceLocationMapper.toDto(repository.save(entity));
    }

    public void deleteById(ServiceLocationPK id) {
        repository.deleteById(id);
    }

    public ServiceLocationDto findById(ServiceLocationPK id) {
        return serviceLocationMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ServiceLocationDto> findByCondition(ServiceLocationDto serviceLocationDto, Pageable pageable) {
        Page<ServiceLocation> entityPage = repository.findAll(pageable);
        List<ServiceLocation> entities = entityPage.getContent();
        return new PageImpl<>(serviceLocationMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ServiceLocationDto update(ServiceLocationDto serviceLocationDto, ServiceLocationPK id) {
        ServiceLocationDto data = findById(id);
        ServiceLocation entity = serviceLocationMapper.toEntity(serviceLocationDto);
        //BeanUtil.copyProperties(data, entity);
        return save(serviceLocationMapper.toDto(entity));
    }
}
