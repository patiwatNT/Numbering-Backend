package com.billng.numbering.service;

import com.billng.numbering.dto.ServiceCenterDto;
import com.billng.numbering.dto.ServiceLocationDto;
import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.dtoC.DropdownDto;
import com.billng.numbering.dtoC.ItemGroup;
import com.billng.numbering.dtoC.ServiceCenterTemp;
import com.billng.numbering.entities.TOTServiceCenter;
import com.billng.numbering.mapper.TOTServiceCenterMapper;
import com.billng.numbering.repository.TOTServiceCenterRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class TOTServiceCenterService {
    private final TOTServiceCenterRepository repository;
    private final TOTServiceCenterMapper tOTServiceCenterMapper;

    public TOTServiceCenterService(TOTServiceCenterRepository repository, TOTServiceCenterMapper tOTServiceCenterMapper) {
        this.repository = repository;
        this.tOTServiceCenterMapper = tOTServiceCenterMapper;
    }

    public TOTServiceCenterDto findByLocationCode(String locationCode) {
        return repository.findByLocationCode(locationCode);
    }

    public List<DropdownDto> findServiceCenter() {
        List<DropdownDto> dropdownDtoList = new ArrayList<>();
        List<ServiceCenterTemp> serviceCenterTempList = repository.findServiceCenter();
        List<String> sectorList = repository.findSector();
        for (String sector : sectorList) {
            DropdownDto dropdownDto = new DropdownDto();
            dropdownDto.setLabel(sector);
            dropdownDto.setValue(sector);
            dropdownDto.setItems(new ArrayList<>());
            for (ServiceCenterTemp locationTemp : serviceCenterTempList) {
                if (dropdownDto.getValue().equals(locationTemp.getSector())) {
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setLabel(locationTemp.getLocationCode() + " : " + locationTemp.getLocationName());
                    itemGroup.setValue(locationTemp.getLocationCode());
                    dropdownDto.getItems().add(itemGroup);
                }
            }
            dropdownDtoList.add(dropdownDto);
        }
        return dropdownDtoList;
    }
//
//    public TOTServiceCenterDto save(TOTServiceCenterDto tOTServiceCenterDto) {
//        TOTServiceCenter entity = tOTServiceCenterMapper.toEntity(tOTServiceCenterDto);
//        return tOTServiceCenterMapper.toDto(repository.save(entity));
//    }
//
//    public void deleteById(String id) {
//        repository.deleteById(id);
//    }
//
//    public TOTServiceCenterDto findById(String id) {
//        return tOTServiceCenterMapper.toDto(repository.findById(id)
//                .orElseThrow(ResourceNotFoundException::new));
//    }
//
//    public Page<TOTServiceCenterDto> findByCondition(TOTServiceCenterDto tOTServiceCenterDto, Pageable pageable) {
//        Page<TOTServiceCenter> entityPage = repository.findAll(pageable);
//        List<TOTServiceCenter> entities = entityPage.getContent();
//        return new PageImpl<>(tOTServiceCenterMapper.toDto(entities), pageable, entityPage.getTotalElements());
//    }
//
//    public TOTServiceCenterDto update(TOTServiceCenterDto tOTServiceCenterDto, String id) {
//        TOTServiceCenterDto data = findById(id);
//        TOTServiceCenter entity = tOTServiceCenterMapper.toEntity(tOTServiceCenterDto);
//        //BeanUtil.copyProperties(data, entity);
//        return save(tOTServiceCenterMapper.toDto(entity));
//    }
}
