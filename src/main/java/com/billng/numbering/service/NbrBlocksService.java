package com.billng.numbering.service;

import com.billng.numbering.dto.*;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.dtoC.BlockList;
import com.billng.numbering.entities.NbrBlocks;
import com.billng.numbering.entities.NbrProviders;
import com.billng.numbering.mapper.NbrBlocksMapper;
import com.billng.numbering.repository.NbrBlocksRepository;
import com.billng.numbering.repository.NbrProvidersRepository;
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
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NbrBlocksService {
    private final NbrBlocksRepository repository;
    private final NbrBlocksMapper nbrBlocksMapper;

    @Autowired
    private NbrProvidersRepository nbrProvidersRepository;

    public NbrBlocksService(NbrBlocksRepository repository, NbrBlocksMapper nbrBlocksMapper) {
        this.repository = repository;
        this.nbrBlocksMapper = nbrBlocksMapper;
    }

    public NbrBlocksDto save(NbrBlocksDto nbrBlocksDto) {
        NbrBlocks entity = nbrBlocksMapper.toEntity(nbrBlocksDto);
        return nbrBlocksMapper.toDto(repository.save(entity));
    }

    public List<NbrBlocksDto> findByCriteria(BlockDetailDtoC blockDetailDtoC){
        log.info("Obj C : {}", blockDetailDtoC);
        String query = buildQuery(blockDetailDtoC);
        //List<NbrBlocksDto> newNbrBlocksDtoList = new ArrayList<>();
        List<NbrBlocksDto> nbrBlocksDtoList = repository.findByCriteria(query);
//        List<ConfigCodeDto> configCodeDtoList = configCodeService.findAll();
//        List<NumberingLocationDto> numberingLocationDtoList = numberingLocationService.findAllCustom();
//        for (ConfigCodeDto temp : configCodeDtoList) {
//            statusCodeMap.put(temp.getStatusCode(), temp.getStatusDescription());
//        }
//        for(NumberingLocationDto temp: numberingLocationDtoList){
//            numberingLocationMap.put(temp.getValue(),temp.getName());
//        }
//        for (BlockDetailDto temp : blockDetailDtoList) {
//            // Change Status Code to Status Description
//            String statusCode = temp.getBlockStatus();
//            if (statusCodeMap.containsKey(statusCode)) {
//                String statusDescription = statusCodeMap.get(statusCode);
//                temp.setBlockStatus(statusDescription);
//            }
//            // Change Location Value to Location Name
//            String locationValue = temp.getLocation();
//            if(numberingLocationMap.containsKey(locationValue)){
//                String locationName = numberingLocationMap.get(locationValue);
//                temp.setLocation(locationName);
//            }
//            newBlockDetailDtoList.add(temp);
//        }
        return nbrBlocksDtoList;
    }

    private String buildQuery(BlockDetailDtoC blockDetailDtoC) {
        StringBuilder queryBuilder = new StringBuilder("1 = 1 AND ");

        addToQuery(queryBuilder, "phone_info", blockDetailDtoC.getPhoneNumber());
        addToQuery(queryBuilder, "provider", blockDetailDtoC.getProvider());
        addToQuery(queryBuilder, "block_status", blockDetailDtoC.getBlockStatus());
        addToQuery(queryBuilder, "block_area", blockDetailDtoC.getLocation());

        return StringUtils.removeEnd(queryBuilder.toString(), " AND ");
    }

    private void addToQuery(StringBuilder queryBuilder, String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            if (fieldName.equals("phone_info")) {
                queryBuilder.append(value).append(" BETWEEN SUBSTRING(block_start,1," + value.length() + ") AND SUBSTRING(block_end,1," + value.length() + ")").append(" AND ");
            } else {
                queryBuilder.append(fieldName).append(" = '").append(value).append("' AND ");
            }
        }
    }

    public NbrBlocksDto findByBlockId(int id){
        return repository.findByBlockId(id);
    }

    public List<BlockDto> getBlockList(){
        List<BlockDto> blockDtoList = new ArrayList<>();
        List<NbrProviders> nbrProvidersList =  nbrProvidersRepository.findAll();
        for(int i = 0;i<=nbrProvidersList.size()-3;i++){
            BlockDto blockDto = new BlockDto();
            int count =  repository.countBlockByProvider(nbrProvidersList.get(i).getProviderId());
            blockDto.setProvide(nbrProvidersList.get(i).getProviderName());
            blockDto.setBlockAmount(BigInteger.valueOf(count));
            blockDto.setNumberAmount(BigInteger.valueOf(count* 1000L));
            blockDto.setFeeAmount(BigDecimal.valueOf(count* 1000L));
            blockDtoList.add(blockDto);
        }
        return blockDtoList;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NbrBlocksDto findById(Integer id) {
        return nbrBlocksMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrBlocksDto> findByCondition(NbrBlocksDto nbrBlocksDto, Pageable pageable) {
        Page<NbrBlocks> entityPage = repository.findAll(pageable);
        List<NbrBlocks> entities = entityPage.getContent();
        return new PageImpl<>(nbrBlocksMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrBlocksDto update(NbrBlocksDto nbrBlocksDto, Integer id) {
        NbrBlocksDto data = findById(id);
        NbrBlocks entity = nbrBlocksMapper.toEntity(nbrBlocksDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrBlocksMapper.toDto(entity));
    }
}
