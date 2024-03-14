package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.BlockDetailDto;
import com.billng.numbering.dtoC.BlockDetailDtoC;
import com.billng.numbering.entities.BlockDetail;
import com.billng.numbering.entities.News;
import com.billng.numbering.mapper.BlockDetailMapper;
import com.billng.numbering.repositoryCustom.BlockDetailRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class BlockDetailRepositoryCustomImpl implements BlockDetailRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    BlockDetailMapper blockDetailMapper;
    @Value("${table.block.detail}")
    private String tableName;

    private String orderBy = " ORDER BY NO";

    @Override
    public List<BlockDetailDto> findByCriteria(String query) {
        try {
            String queryString = "SELECT * FROM " + tableName + " WHERE " + query + orderBy;
            return blockDetailMapper.toDto(entityManager.createNativeQuery(queryString, BlockDetail.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
