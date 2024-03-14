package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NewsDto;
import com.billng.numbering.entities.News;
import com.billng.numbering.mapper.NewsMapper;
import com.billng.numbering.repositoryCustom.NewsRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NewsRepositoryCustomImpl implements NewsRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NewsMapper newsMapper;

    @Value("${table.news}")
    private String tableName;

    @Override
    public List<NewsDto> findAllCustom() {
        try {
            String queryString = "SELECT * FROM " + tableName + " ORDER BY UPDATE_DATE DESC";
            return newsMapper.toDto(entityManager.createNativeQuery(queryString, News.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NewsDto findByIdCustom(String id) {
        try {
            String queryString = "SELECT * FROM " + tableName + " WHERE ID = '" + id + "' ORDER BY CREATE_DATE desc";
            return newsMapper.toDto((News) entityManager.createNativeQuery(queryString, News.class).getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
