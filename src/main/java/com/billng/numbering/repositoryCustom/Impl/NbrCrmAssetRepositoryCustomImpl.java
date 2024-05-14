package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrCrmAssetDto;
import com.billng.numbering.entities.NbrCrmAsset;
import com.billng.numbering.mapper.NbrBlocksMapper;
import com.billng.numbering.mapper.NbrCrmAssetMapper;
import com.billng.numbering.repositoryCustom.NbrCrmAssetRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class NbrCrmAssetRepositoryCustomImpl implements NbrCrmAssetRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrCrmAssetMapper nbrCrmAssetMapper;
    @Value("${table.numbering.crm.asset}")
    String tableName;
    @Override
    public NbrCrmAssetDto findByTelNo(String telNo) {
        try{
            String query = "Select * From " + tableName + " Where telno = '" + telNo + "'";
            return nbrCrmAssetMapper.toDto((NbrCrmAsset) entityManager.createNativeQuery(query, NbrCrmAsset.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
