package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.ReportN11Active;
import com.billng.numbering.dtoC.ReportN11InactiveAndInProgress;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.repositoryCustom.ReportN11RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ReportN11RepositoryCustomImpl implements ReportN11RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrAssignedMapper nbrAssignedMapper;
    @Value("${table.numbering.assigned}")
    String tableName;
    @Override
    public List<ReportN11Active> findAllReportActive() {
        try{
            String query = "SELECT A.provider_id, A.providerName provider, A.blockStatus\n" +
                    "\t\t\t\t, SUM(DISTINCT A.qtyBlock) qtyBlock\n" +
                    "\t\t\t\t, SUM(DISTINCT A.qtyNo) qtyNo\n" +
                    "\t\t\t\t, SUM(DISTINCT A.qtyPay) qtyPay\n" +
                    "\t\t\t\t, SUM(DISTINCT B.qtyAssigned) qtyAssigned\n" +
                    "\t\t\t\t, SUM(DISTINCT C.qtyActive) qtyActive\n" +
                    "\t\t\t\t, SUM(DISTINCT D.qtyActiveAssigned) qtyActiveAssigned\n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t(\n" +
                    "\t\t\t\tSELECT B.provider_id\n" +
                    "\t\t\t\t\t, CASE P.provider_name WHEN 'TRUE-1' THEN 'TRUE' ELSE P.provider_name END providerName \n" +
                    "\t\t\t\t\t, COUNT(block_id) qtyBlock\n" +
                    "\t\t\t\t\t, SUM(block_amount) qtyNo\n" +
                    "\t\t\t\t\t, SUM(block_payable) qtyPay\n" +
                    "\t\t\t\t\t, CASE block_status WHEN 1 THEN 1 WHEN 0 THEN 0 WHEN 2 THEN 2 END blockStatus\n" +
                    "\t\t\t\tFROM NBR_BLOCKS B\n" +
                    "\t\t\t\tLEFT JOIN NBR_PROVIDERS P ON B.provider_id=P.provider_id\n" +
                    "\t\t\t\tWHERE block_status=1\n" +
                    "\t\t\t\tGROUP BY B.provider_id, P.provider_name, B.block_status\n" +
                    "\t\t\t) A\n" +
                    "\t\t\tLEFT JOIN\n" +
                    "\t\t\t(\n" +
                    "\t\t\t\tSELECT CASE provider_id WHEN 4 THEN 3 ELSE provider_id END providerId\n" +
                    "\t\t\t\t\t, COUNT(service_no) qtyAssigned\n" +
                    "\t\t\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\t\t\tWHERE block_id IN (SELECT block_id FROM NBR_BLOCKS WHERE block_status=1)\n" +
                    "\t\t\t\t\tAND assigned_id IS NOT NULL\n" +
                    "\t\t\t\tGROUP BY provider_id\n" +
                    "\t\t\t) B ON A.provider_id=B.providerId\n" +
                    "\t\t\tLEFT JOIN\n" +
                    "\t\t\t(\n" +
                    "\t\t\t\tSELECT CASE provider_id WHEN 4 THEN 3 ELSE provider_id END providerId\n" +
                    "\t\t\t\t\t, COUNT(service_no) qtyActive\n" +
                    "\t\t\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\t\t\tWHERE block_id IN (SELECT block_id FROM NBR_BLOCKS WHERE block_status=1)\n" +
                    "\t\t\t\t\tAND (/*crmStatus IS NOT NULL OR*/ crm_status<>2)\n" +
                    "\t\t\t\t\tAND assigned_id IS NOT NULL\n" +
                    "\t\t\t\tGROUP BY provider_id\n" +
                    "\t\t\t) C ON A.provider_id=C.providerId\n" +
                    "\t\t\tLEFT JOIN\n" +
                    "\t\t\t(\n" +
                    "\t\t\t\tSELECT CASE provider_id WHEN 4 THEN 3 ELSE provider_id END providerId\n" +
                    "\t\t\t\t\t, COUNT(service_no) qtyActiveAssigned\n" +
                    "\t\t\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\t\t\tWHERE block_id IN (SELECT block_id FROM NBR_BLOCKS WHERE block_status=1)\n" +
                    "\t\t\t\t\tAND (/*crmStatus IS NOT NULL OR*/ crm_status<>2)\n" +
                    "\t\t\t\t\tAND assigned_id IS NULL\n" +
                    "\t\t\t\tGROUP BY provider_id\n" +
                    "\t\t\t) D ON A.provider_id=D.providerId\n" +
                    "\t\t\tGROUP BY A.provider_id, A.providerName, A.blockStatus\n" +
                    "\t\t\tORDER BY A.provider_id";
            return entityManager.createNativeQuery(query, ReportN11Active.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ReportN11InactiveAndInProgress> findAllReportInactive() {
        try{
            String query = "SELECT provider, provider_id\n" +
                    "\t\t\t\t, block_status\n" +
                    "\t\t\t\t, COUNT(block_id) qtyBlock\n" +
                    "\t\t\t\t, SUM(block_amount) qtyNo\n" +
                    "\t\t\t\t, SUM(block_payable) qtyPay\n" +
                    "\t\t\tFROM NBR_BLOCKS\n" +
                    "\t\t\tWHERE block_status=0\n" +
                    "\t\t\tGROUP BY provider, provider_id, block_status\n" +
                    "\t\t\tORDER BY provider_id";
            return entityManager.createNativeQuery(query, ReportN11InactiveAndInProgress.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ReportN11InactiveAndInProgress> findAllReportInProgress() {
        try{
            String query = "SELECT provider, provider_id\n" +
                    "\t\t\t\t, block_status\n" +
                    "\t\t\t\t, COUNT(block_id) qtyBlock\n" +
                    "\t\t\t\t, SUM(block_amount) qtyNo\n" +
                    "\t\t\t\t, SUM(block_payable) qtyPay\n" +
                    "\t\t\tFROM NBR_BLOCKS\n" +
                    "\t\t\tWHERE block_status=2\n" +
                    "\t\t\tGROUP BY provider, provider_id, block_status\n" +
                    "\t\t\tORDER BY provider_id";
            return entityManager.createNativeQuery(query, ReportN11InactiveAndInProgress.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
