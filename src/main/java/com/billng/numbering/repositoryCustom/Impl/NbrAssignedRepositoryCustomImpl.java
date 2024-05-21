package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dto.NbrAssignedDto;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.NbrAssignedAmount;
import com.billng.numbering.entities.NbrAssigned;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.mapper.NbrProvidersMapper;
import com.billng.numbering.repositoryCustom.NbrAssignedRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class NbrAssignedRepositoryCustomImpl implements NbrAssignedRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrAssignedMapper nbrAssignedMapper;
    @Value("${table.numbering.assigned}")
    String tableName;
    @Override
    public NbrAssignedDto findByAssignedId(String id) {
        try{
            String query = "Select * From " + tableName + " Where assigned_id = '" + id + "'";
            return nbrAssignedMapper.toDto((NbrAssigned) entityManager.createNativeQuery(query, NbrAssigned.class).getSingleResult());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int countAssignedByProviderId(int providerId) {
        try{
            String query = "Select count(*) From " + tableName + " Where provider_id = " + providerId;
            return ((Number) entityManager.createNativeQuery(query).getSingleResult()).intValue();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int sumAssignedQtyByProviderId(int providerId) {
        try{
            String query = "Select sum(assigned_qty) From " + tableName + " Where provider_id = " + providerId;
            return ((Number) entityManager.createNativeQuery(query).getSingleResult()).intValue();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<NbrAssignedDto> findByCriteria(String query) {
        try{
            String queryString = "Select * From " + tableName + " Where " + query + " order by assigned_start ";
            return nbrAssignedMapper.toDto(entityManager.createNativeQuery(queryString, NbrAssigned.class).getResultList());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> findAssignedRegion() {
        try{
            String queryString = "Select DISTINCT assigned_region From " + tableName + " order by assigned_region";
            return entityManager.createNativeQuery(queryString,String.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> findAssignedDept() {
        try{
            String queryString = "Select DISTINCT assigned_dept From " + tableName + " order by assigned_dept";
            return entityManager.createNativeQuery(queryString,String.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> findAssignedSector() {
        try{
            String queryString = "Select DISTINCT assigned_sector From " + tableName + " order by assigned_sector";
            return entityManager.createNativeQuery(queryString,String.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NbrAssignedAmount> findAssignedAmount(String query) {
        try{
            String queryString = "SELECT \n" +
                    "    Q.assigned_id, \n" +
                    "    Q.qty, \n" +
                    "    Q.okLocation, \n" +
                    "    Q.noLocation\n" +
                    "FROM \n" +
                    "    NBR_ASSIGNED A\n" +
                    "LEFT JOIN \n" +
                    "    NBR_PROVIDERS P ON A.provider_id = P.provider_id\n" +
                    "LEFT JOIN \n" +
                    "    (\n" +
                    "        SELECT \n" +
                    "            A.assigned_id, \n" +
                    "            A.qty, \n" +
                    "            B.okLocation, \n" +
                    "            C.noLocation\n" +
                    "        FROM\n" +
                    "            (\n" +
                    "                SELECT \n" +
                    "                    assigned_id, \n" +
                    "                    COUNT(service_no) qty\n" +
                    "                FROM \n" +
                    "                    NBR_SERVICE_NUMBERS\n" +
                    "                GROUP BY \n" +
                    "                    assigned_id\n" +
                    "            ) A \n" +
                    "        LEFT JOIN\n" +
                    "            (\n" +
                    "                SELECT \n" +
                    "                    assigned_id, \n" +
                    "                    COUNT(service_no) okLocation\n" +
                    "                FROM \n" +
                    "                    NBR_SERVICE_NUMBERS\n" +
                    "                WHERE \n" +
                    "                    location_code IS NOT NULL\n" +
                    "                GROUP BY \n" +
                    "                    assigned_id\n" +
                    "            ) B ON A.assigned_id = B.assigned_id\n" +
                    "        LEFT JOIN \n" +
                    "            (\n" +
                    "                SELECT \n" +
                    "                    assigned_id, \n" +
                    "                    COUNT(service_no) noLocation\n" +
                    "                FROM \n" +
                    "                    NBR_SERVICE_NUMBERS\n" +
                    "                WHERE \n" +
                    "                    location_code IS NULL\n" +
                    "                GROUP BY \n" +
                    "                    assigned_id\n" +
                    "            ) C ON A.assigned_id = C.assigned_id\n" +
                    "    ) Q ON A.assigned_id = Q.assigned_id\n" +
                    "\t where "+query+"\n"+
                    "\torder by A.assigned_start";
            return entityManager.createNativeQuery(queryString,NbrAssignedAmount.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
