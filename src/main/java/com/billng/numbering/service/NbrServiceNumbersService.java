package com.billng.numbering.service;

import com.billng.numbering.dto.NbrServiceNumbersDto;
import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.entities.NbrServiceNumbers;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repository.NbrServiceNumbersRepository;
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
public class NbrServiceNumbersService {
    private final NbrServiceNumbersRepository repository;
    private final NbrServiceNumbersMapper nbrServiceNumbersMapper;

    @Autowired
    private TOTServiceCenterService totServiceCenterService;

    public NbrServiceNumbersService(NbrServiceNumbersRepository repository, NbrServiceNumbersMapper nbrServiceNumbersMapper) {
        this.repository = repository;
        this.nbrServiceNumbersMapper = nbrServiceNumbersMapper;
    }

    public NbrServiceNumbersDto findByServiceNo(String serviceNo){
        return repository.findByServiceNumber(serviceNo);
    }

    public List<NbrServiceNumbersDto> findByAssignedId(int id){
        List<NbrServiceNumbersDto> nbrServiceNumbersDtoList = repository.findByAssignedId(id);
        List<NbrServiceNumbersDto> newNbrServiceNumbersDtoList = new ArrayList<>();
        for(NbrServiceNumbersDto temp : nbrServiceNumbersDtoList){
           String locationCode = temp.getLocationCode();
            TOTServiceCenterDto totServiceCenterDto = totServiceCenterService.findByLocationCode(locationCode);
            String locationAbbr = totServiceCenterDto.getLocationAbbr();
            temp.setLocationCode(locationCode + ":" + locationAbbr);
            newNbrServiceNumbersDtoList.add(temp);
        }
        return newNbrServiceNumbersDtoList;
    }

    public void updateServiceLocation(NbrServiceNumbersDto nbrServiceNumbersDto){

        repository.updateServiceLocation(nbrServiceNumbersDto);
    }

    public NbrServiceNumbersDto save(NbrServiceNumbersDto nbrServiceNumbersDto) {
        NbrServiceNumbers entity = nbrServiceNumbersMapper.toEntity(nbrServiceNumbersDto);
        return nbrServiceNumbersMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public NbrServiceNumbersDto findById(String id) {
        return nbrServiceNumbersMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrServiceNumbersDto> findByCondition(NbrServiceNumbersDto nbrServiceNumbersDto, Pageable pageable) {
        Page<NbrServiceNumbers> entityPage = repository.findAll(pageable);
        List<NbrServiceNumbers> entities = entityPage.getContent();
        return new PageImpl<>(nbrServiceNumbersMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrServiceNumbersDto update(NbrServiceNumbersDto nbrServiceNumbersDto, String id) {
        NbrServiceNumbersDto data = findById(id);
        NbrServiceNumbers entity = nbrServiceNumbersMapper.toEntity(nbrServiceNumbersDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrServiceNumbersMapper.toDto(entity));
    }
}
