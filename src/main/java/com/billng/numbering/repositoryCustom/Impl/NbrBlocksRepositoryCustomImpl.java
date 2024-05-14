package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrBlocksDto;
import com.billng.numbering.entities.NbrBlocks;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.mapper.NbrBlocksMapper;
import com.billng.numbering.repositoryCustom.NbrBlocksRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NbrBlocksRepositoryCustomImpl implements NbrBlocksRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrBlocksMapper nbrBlocksMapper;
    @Value("${table.numbering.block}")
    String tableName;
    @Override
    public NbrBlocksDto findByBlockId(int id) {
        try{
            String query = "Select * From " + tableName + " Where block_id = '" + id + "'";
            return nbrBlocksMapper.toDto((NbrBlocks) entityManager.createNativeQuery(query, NbrBlocks.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int countBlockByProvider(int providerId) {
        try{
            String query = "Select count(*) From " + tableName + " Where provider_id = " + providerId + " and block_status = 1";
            return ((Number) entityManager.createNativeQuery(query).getSingleResult()).intValue();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<NbrBlocksDto> findByCriteria(String query) {
        System.out.println("Query : "+query);
        try{
            String queryString = "Select * From " + tableName + " Where " + query;
            return nbrBlocksMapper.toDto(entityManager.createNativeQuery(queryString,NbrBlocks.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
