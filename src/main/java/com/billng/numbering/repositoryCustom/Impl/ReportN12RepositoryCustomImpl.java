package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.NbrReportN12;
import com.billng.numbering.dtoC.ReportN11InactiveAndInProgress;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.repositoryCustom.ReportN12RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ReportN12RepositoryCustomImpl implements ReportN12RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrAssignedMapper nbrAssignedMapper;
    @Value("${table.numbering.assigned}")
    String tableName;
    @Override
    public List<NbrReportN12> findReportN12() {
        try{
            String query = "SELECT A.block_id, A.block_start, A.block_end\n" +
                    "\t\t, CASE block_status \n" +
                    "\t\t\tWHEN 1 THEN 1 \n" +
                    "\t\t\tWHEN 0 THEN 0 \n" +
                    "\t\t\tEND blockStatus\n" +
                    "\t\t, S.qtyNo, S.qtyAssigned, B.qtyActive\n" +
                    "\t\t, R.rsvId\n" +
                    "\t\t, CASE WHEN R.rsvId IS NOT NULL THEN 'Reserved' ELSE '-' END rsvStatus\n" +
                    "\tFROM\n" +
                    "\t\t(\n" +
                    "\t\t\tSELECT block_id, block_start, block_end, block_status\n" +
                    "\t\t\tFROM NBR_BLOCKS\n" +
                    "\t\t) A LEFT JOIN\n" +
                    "\t\t(\n" +
                    "\t\t\tSELECT block_id, COUNT(assigned_id) qtyAssigned, COUNT(service_no) qtyNo\n" +
                    "\t\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\t\tWHERE block_id IS NOT NULL\n" +
                    "\t\t\tGROUP BY block_id\n" +
                    "\t\t) S ON A.block_id=S.block_id LEFT JOIN\n" +
                    "\t\t(\n" +
                    "\t\t\tSELECT block_id, COUNT(service_no) qtyActive\n" +
                    "\t\t\tFROM NBR_SERVICE_NUMBERS\n" +
                    "\t\t\tWHERE block_id IS NOT NULL AND crm_status IS NOT NULL AND crm_status<>2\n" +
                    "\t\t\tGROUP BY block_id\n" +
                    "\t\t) B ON S.block_id=B.block_id LEFT JOIN\n" +
                    "\t\tNBR_RESERVE R ON R.rsvStart BETWEEN A.block_start AND A.block_end\n" +
                    "\tWHERE A.block_status=1 AND qtyActive IS NULL\n" +
                    "\tORDER BY block_id";
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
            return entityManager.createNativeQuery(query, NbrReportN12.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
