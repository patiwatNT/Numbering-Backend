package com.billng.numbering.service;

import com.billng.numbering.dto.NbrRolesDto;
import com.billng.numbering.dto.NbrUsersRolesDto;
import com.billng.numbering.dtoC.NbrRolePrivilege;
import com.billng.numbering.entities.NbrRoles;
import com.billng.numbering.mapper.NbrRolesMapper;
import com.billng.numbering.mapper.NbrUsersRolesMapper;
import com.billng.numbering.repository.NbrRolesRepository;
import com.billng.numbering.repository.NbrUsersRolesRepository;
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
public class NbrRolesService {
    private final NbrRolesRepository repository;
    private final NbrRolesMapper nbrRolesMapper;
    @Autowired
    private NbrUsersRolesRepository nbrUsersRolesRepository;
    @Autowired
    private NbrUsersRolesMapper nbrUsersRolesMapper;

    public NbrRolesService(NbrRolesRepository repository, NbrRolesMapper nbrRolesMapper) {
        this.repository = repository;
        this.nbrRolesMapper = nbrRolesMapper;
    }

    public List<NbrRolePrivilege> findAll(String empCode){
        List<NbrRolePrivilege> nbrRolePrivilegeList = new ArrayList<>();
        NbrUsersRolesDto nbrUsersRolesDto = nbrUsersRolesRepository.findByEmpId(empCode);
        List<NbrRolesDto> nbrRolesDto = nbrRolesMapper.toDto(repository.findAll());
        // Assuming nbrRolesDto and nbrUsersRolesDto are lists
        for (int i = 0; i < nbrRolesDto.size(); i++) {
            NbrRolePrivilege nbrRolePrivilege = new NbrRolePrivilege();
            nbrRolePrivilege.setNbrRolesDto(nbrRolesDto.get(i));
            nbrRolePrivilege.setPrivilege(replacePrivilege(getRoleFromNbrUsersRolesDto(nbrUsersRolesDto, i + 1)));
            nbrRolePrivilegeList.add(nbrRolePrivilege);
        }
        return nbrRolePrivilegeList;
    }

    // Method to get the role from nbrUsersRolesDto based on index
    private int getRoleFromNbrUsersRolesDto(NbrUsersRolesDto nbrUsersRolesDto, int index) {
        return switch (index) {
            case 1 -> (nbrUsersRolesDto.getRole1() != 0) ? nbrUsersRolesDto.getRole1() : 0;
            case 2 -> (nbrUsersRolesDto.getRole2() != 0) ? nbrUsersRolesDto.getRole2() : 0;
            case 3 -> (nbrUsersRolesDto.getRole3() != 0) ? nbrUsersRolesDto.getRole3() : 0;
            case 4 -> (nbrUsersRolesDto.getRole4() != 0) ? nbrUsersRolesDto.getRole4() : 0;
            case 5 -> (nbrUsersRolesDto.getRole5() != 0) ? nbrUsersRolesDto.getRole5() : 0;
            case 6 -> (nbrUsersRolesDto.getRole6() != 0) ? nbrUsersRolesDto.getRole6() : 0;
            case 7 -> (nbrUsersRolesDto.getRole7() != null) ? nbrUsersRolesDto.getRole7() : 0;
            case 8 -> (nbrUsersRolesDto.getRole8() != null) ? nbrUsersRolesDto.getRole8() : 0;
            case 9 -> (nbrUsersRolesDto.getRole9() != null) ? nbrUsersRolesDto.getRole9() : 0;
            case 10 -> (nbrUsersRolesDto.getRole10() != null) ? nbrUsersRolesDto.getRole10() : 0;
            case 11 -> (nbrUsersRolesDto.getRep1() != null) ? nbrUsersRolesDto.getRep1() : 0;
            case 12 -> (nbrUsersRolesDto.getRep2() != null) ? nbrUsersRolesDto.getRep2() : 0;
            case 13 -> (nbrUsersRolesDto.getRep3() != null) ? nbrUsersRolesDto.getRep3() : 0;
            case 14 -> (nbrUsersRolesDto.getRep4() != null) ? nbrUsersRolesDto.getRep4() : 0;
            case 15 -> (nbrUsersRolesDto.getRep5() != null) ? nbrUsersRolesDto.getRep5() : 0;
            default -> 0;
        };
    }

    public String replacePrivilege(int privilege){
        if(privilege==1){
            return "มีสิทธิ์";
        }else{
            return "ไม่มีสิทธิ์";
        }
    }

    public NbrRolesDto save(NbrRolesDto nbrRolesDto) {
        NbrRoles entity = nbrRolesMapper.toEntity(nbrRolesDto);
        return nbrRolesMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NbrRolesDto findById(Integer id) {
        return nbrRolesMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NbrRolesDto> findByCondition(NbrRolesDto nbrRolesDto, Pageable pageable) {
        Page<NbrRoles> entityPage = repository.findAll(pageable);
        List<NbrRoles> entities = entityPage.getContent();
        return new PageImpl<>(nbrRolesMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NbrRolesDto update(NbrRolesDto nbrRolesDto, Integer id) {
        NbrRolesDto data = findById(id);
        NbrRoles entity = nbrRolesMapper.toEntity(nbrRolesDto);
        //BeanUtil.copyProperties(data, entity);
        return save(nbrRolesMapper.toDto(entity));
    }
}
