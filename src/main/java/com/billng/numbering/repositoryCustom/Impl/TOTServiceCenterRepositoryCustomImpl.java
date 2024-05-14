package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.dtoC.ServiceCenterTemp;
import com.billng.numbering.entities.TOTServiceCenter;
import com.billng.numbering.mapper.TOTServiceCenterMapper;
import com.billng.numbering.repositoryCustom.TOTServiceCenterRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class TOTServiceCenterRepositoryCustomImpl implements TOTServiceCenterRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    TOTServiceCenterMapper totServiceCenterMapper;
    @Value("${table.numbering.tot.service_center}")
    String tableName;

    @Override
    public TOTServiceCenterDto findByLocationCode(String locationCode) {
        try{
            String query = "SELECT * FROM " + tableName + " WHERE location_code = '" + locationCode + "'";
            return totServiceCenterMapper.toDto((TOTServiceCenter) entityManager.createNativeQuery(query, TOTServiceCenter.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ServiceCenterTemp> findServiceCenter() {
        try{
            String query = "SELECT location_code , location_abbr , sector FROM " + tableName + " WHERE stop_date = '' order by sector";
            return entityManager.createNativeQuery(query, ServiceCenterTemp.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> findSector() {
        try{
            String query = "SELECT distinct sector FROM " + tableName + " WHERE stop_date = '' order by sector";
            return entityManager.createNativeQuery(query, String.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
