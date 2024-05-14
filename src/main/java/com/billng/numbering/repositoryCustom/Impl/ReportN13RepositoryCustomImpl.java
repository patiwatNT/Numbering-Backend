package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.NbrReportN12;
import com.billng.numbering.dtoC.NbrReportN13;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.repositoryCustom.ReportN13RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ReportN13RepositoryCustomImpl implements ReportN13RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrAssignedMapper nbrAssignedMapper;
    @Value("${table.numbering.assigned}")
    String tableName;
    @Override
    public List<NbrReportN13> findReportN13() {
        try{
            String query = "SELECT A.block_id, A.block_start, A.block_end, A.doc_ref\n" +
                    "\t\t, CASE block_status \n" +
                    "\t\t\tWHEN 1 THEN 1 \n" +
                    "\t\t\tWHEN 0 THEN 0 \n" +
                    "\t\t\tEND blockStatus\n" +
                    "\t\t, S.qtyNo, S.qtyAssigned, B.qtyActive\n" +
                    "\tFROM\n" +
                    "\t(\n" +
                    "\t\tSELECT block_id, block_start, block_end, block_status, doc_ref\n" +
                    "\t\tFROM NBR_BLOCKS\n" +
                    "\t) A LEFT JOIN\n" +
                    "\t(\n" +
                    "\t\tSELECT block_id, COUNT(assigned_id) qtyAssigned, COUNT(service_no) qtyNo\n" +
                    "\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\tWHERE block_id IS NOT NULL\n" +
                    "\t\tGROUP BY block_id\n" +
                    "\t) S ON A.block_id=S.block_id LEFT JOIN\n" +
                    "\t(\n" +
                    "\t\tSELECT block_id, COUNT(service_no) qtyActive\n" +
                    "\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\tWHERE block_id IS NOT NULL AND crm_status IS NOT NULL AND crm_status<>2\n" +
                    "\t\tGROUP BY block_id\n" +
                    "\t) B ON S.block_id=B.block_id\n" +
                    "\tWHERE A.block_status=0 AND qtyActive IS NOT NULL\n" +
                    "\tORDER BY A.block_start";
//            List<Object[]> resultList = entityManager.createNativeQuery(query).getResultList();
//
//            for (Object[] row : resultList) {
//                // Print the data type of each value
//                for (Object value : row) {
//                    if(value!=null){
//                    System.out.print(value.getClass().getName() + ": " + value + "\t");
//                    }
//                }
//                System.out.println(); // Move to the next line after printing all column values
//            }
            return entityManager.createNativeQuery(query, NbrReportN13.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
