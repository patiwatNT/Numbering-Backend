package com.billng.numbering.service;

import com.billng.numbering.dto.ConfigCodeDto;
import com.billng.numbering.dto.NumberingPrivilegesDto;
import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.dto.NumberingUsersDto;
import com.billng.numbering.dtoC.NumberingUserDetail;
import com.billng.numbering.dtoC.NumberingUserPrivilege;
import com.billng.numbering.entities.NumberingRolePrivileges;
import com.billng.numbering.entities.NumberingUsers;
import com.billng.numbering.mapper.NumberingPrivilegesMapper;
import com.billng.numbering.mapper.NumberingRolePrivilegesMapper;
import com.billng.numbering.mapper.NumberingUsersMapper;
import com.billng.numbering.repository.NumberingPrivilegesRepository;
import com.billng.numbering.repository.NumberingRolePrivilegesRepository;
import com.billng.numbering.repository.NumberingUsersRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class NumberingUsersService {
    private final NumberingUsersRepository numberingUsersRepository;
    private final NumberingRolePrivilegesRepository numberingRolePrivilegesRepository;
    @Autowired
    private NumberingPrivilegesRepository numberingPrivilegesRepository;
    private final NumberingUsersMapper numberingUsersMapper;
    @Autowired
    private NumberingPrivilegesMapper numberingPrivilegesMapper;
    @Autowired
    private NumberingRolePrivilegesMapper numberingRolePrivilegesMapper;
    Map<BigInteger,String> privilegeMap = new HashMap<>();
    @Autowired
    private ConfigCodeService configCodeService;
    Map<String,String> codeConfigMap = new HashMap<>();

    public NumberingUsersService(NumberingUsersRepository numberingUsersRepository, NumberingUsersMapper numberingUsersMapper, NumberingRolePrivilegesRepository numberingRolePrivilegesRepository) {
        this.numberingUsersRepository = numberingUsersRepository;
        this.numberingUsersMapper = numberingUsersMapper;
        this.numberingRolePrivilegesRepository = numberingRolePrivilegesRepository;
    }

    public NumberingUsersDto save(NumberingUsersDto numberingUsersDto) {
        NumberingUsers entity = numberingUsersMapper.toEntity(numberingUsersDto);
        return numberingUsersMapper.toDto(numberingUsersRepository.save(entity));
    }

    public NumberingUsersDto findByUsername(String username){
        return numberingUsersRepository.findByUsername(username);
    }

    public NumberingUserDetail findUserDetail(String username) {
        NumberingUsersDto numberingUsersDto = numberingUsersRepository.findByUsername(username);
        List<NumberingRolePrivilegesDto> numberingRolePrivilegesDtoList = numberingRolePrivilegesRepository.findByRoleId(numberingUsersDto.getRoleId().getRoleId());

        // Replace Privilege ID to Privilege Name
        List<NumberingPrivilegesDto> numberingPrivilegesDtoList = numberingPrivilegesMapper.toDto(numberingPrivilegesRepository.findAll());
        for(NumberingPrivilegesDto temp:numberingPrivilegesDtoList){
            privilegeMap.put(temp.getPrivilegeId(), temp.getPrivilegeName());
        }
        List<NumberingUserPrivilege> numberingUserPrivilegeList = new ArrayList<>();
        for(NumberingRolePrivilegesDto temp:numberingRolePrivilegesDtoList){
            BigInteger privilegeId = temp.getNumberingRolePrivilegesPK().getPrivilegeId();
            if(privilegeMap.containsKey(privilegeId)){
                NumberingUserPrivilege obj = new NumberingUserPrivilege();
                obj.setPrivilegeId(String.valueOf(privilegeId));
                obj.setPrivilegeName(privilegeMap.get(privilegeId));
                obj.setAccessRight(temp.getAccessRights());
                numberingUserPrivilegeList.add(obj);
            }
        }

        List<ConfigCodeDto> configCodeDtoList = configCodeService.findByStatusGroup("USER");
        for(ConfigCodeDto temp:configCodeDtoList){
            codeConfigMap.put(temp.getStatusCode(),temp.getStatusDescription());
        }
        for(NumberingUserPrivilege temp:numberingUserPrivilegeList){
            String statusCode = temp.getAccessRight();
            if(codeConfigMap.containsKey(statusCode)){
                temp.setAccessRight(codeConfigMap.get(statusCode));
            }
        }

        NumberingUserDetail numberingUserDetail = new NumberingUserDetail();
        numberingUserDetail.setUsername(numberingUsersDto.getUsername());
        numberingUserDetail.setRoleId(numberingUsersDto.getRoleId().getRoleId());
        numberingUserDetail.setNumberingUserPrivilegeList(numberingUserPrivilegeList);

        return numberingUserDetail;
    }

    public void deleteById(BigDecimal id) {
        numberingUsersRepository.deleteById(id);
    }

    public NumberingUsersDto findById(BigDecimal id) {
        return numberingUsersMapper.toDto(numberingUsersRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NumberingUsersDto> findByCondition(NumberingUsersDto numberingUsersDto, Pageable pageable) {
        Page<NumberingUsers> entityPage = numberingUsersRepository.findAll(pageable);
        List<NumberingUsers> entities = entityPage.getContent();
        return new PageImpl<>(numberingUsersMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NumberingUsersDto update(NumberingUsersDto numberingUsersDto, BigDecimal id) {
        NumberingUsersDto data = findById(id);
        NumberingUsers entity = numberingUsersMapper.toEntity(numberingUsersDto);
        //BeanUtil.copyProperties(data, entity);
        return save(numberingUsersMapper.toDto(entity));
    }
}
