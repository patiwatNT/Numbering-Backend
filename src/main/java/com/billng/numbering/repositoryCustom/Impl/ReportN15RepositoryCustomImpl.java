package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.NbrReportN13;
import com.billng.numbering.dtoC.NbrReportN15;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.repositoryCustom.ReportN15RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ReportN15RepositoryCustomImpl implements ReportN15RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrAssignedMapper nbrAssignedMapper;
    @Value("${table.numbering.assigned}")
    String tableName;
    @Override
    public List<NbrReportN15> findReportN15() {
        try{
            String query = "SELECT Region, Department, Sector, Location_Code, Location_Abbr\n" +
                    "\t\t, qtyAssigned, qtyActive, qtyAssigned-qtyActive  qtyEmpty \n" +
                    "\t\t, qtyActive*100/qtyAssigned percentUtl\n" +
                    "\tFROM \n" +
                    "\t(\n" +
                    "\tSELECT CASE WHEN SC.Location_Code IS NULL THEN A.assigned_region ELSE SC.Region END Region\n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN A.assigned_dept ELSE SC.Department END Department\n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN A.assigned_sector ELSE SC.Sector END Sector\n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN 'No Location' ELSE SC.Location_Code END Location_Code\n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN 'No Location' ELSE SC.Location_Abbr END Location_Abbr\n" +
                    "\t\t, COUNT(service_no) qtyAssigned\n" +
                    "\t\t, SUM(CASE WHEN /*SN.crmStatus IS NOT NULL OR*/ SN.crm_status<>2 THEN 1 ELSE 0 END) qtyActive\n" +
                    "\tFROM TOTServiceCenter SC\n" +
                    "\tFULL JOIN NBR_SERVICE_NUMBERS SN ON SC.Location_Code=SN.location_code\n" +
                    "\tLEFT JOIN NBR_ASSIGNED A ON SN.assigned_id=A.assigned_id\n" +
                    "\tWHERE SN.block_id IN (SELECT block_id FROM NBR_BLOCKS WHERE block_status=1 GROUP BY block_id)\n" +
                    "\t\tAND A.assigned_id IS NOT NULL\n" +
                    "\tGROUP BY CASE WHEN SC.Location_Code IS NULL THEN A.assigned_region ELSE SC.Region END \n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN A.assigned_dept ELSE SC.Department END \n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN A.assigned_sector ELSE SC.Sector END \n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN 'No Location' ELSE SC.Location_Code END \n" +
                    "\t\t, CASE WHEN SC.Location_Code IS NULL THEN 'No Location' ELSE SC.Location_Abbr END \n" +
                    "\t--GROUP BY SC.Region, SC.Department, SC.Sector, SC.Location_Code, SC.Location_Abbr\n" +
                    "\t) A\n" +
                    "\tORDER BY Region, Department, Sector, Location_Code";
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
            return entityManager.createNativeQuery(query, NbrReportN15.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
