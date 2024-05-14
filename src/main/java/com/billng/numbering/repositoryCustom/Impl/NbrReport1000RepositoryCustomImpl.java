package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.NbrReportN16;
import com.billng.numbering.entities.NbrServiceNumbers;
import com.billng.numbering.mapper.NbrServiceNumbersMapper;
import com.billng.numbering.repositoryCustom.NbrReport1000RepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NbrReport1000RepositoryCustomImpl implements NbrReport1000RepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    NbrServiceNumbersMapper nbrServiceNumbersMapper;
    @Value("${table.phone.info}")
    String tableName;

    @Override
    public List<NbrReportN16> findReportN16Inc() {
        try{
            String query = "SELECT 'Block-1000' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT1000\n" +
                    "\tUNION\n" +
                    "\tSELECT 'Block-500 (INC.)' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT500\n" +
                    "\tUNION\n" +
                    "\tSELECT 'Block-100 (INC.)' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT100\n" +
                    "\tORDER BY qtyRange";
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
            return entityManager.createNativeQuery(query, NbrReportN16.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NbrReportN16> findReportN16Only() {
        try{
            String query = "SELECT 'Block-1000' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT1000 \n" +
                    "\tUNION\n" +
                    "\tSELECT 'Block-500 (ONLY)' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT500 WHERE block_id NOT IN (SELECT block_id FROM NBR_REPORT1000)\n" +
                    "\tUNION\n" +
                    "\tSELECT 'Block-100 (ONLY)' block, COUNT(*) qtyRange, SUM(qty) qty, SUM(amt) amt, SUM(amt)*12/1000000 amtYearly FROM NBR_REPORT100 t1\n" +
                    "\tWHERE NOT EXISTS\n" +
                    "\t   (SELECT 1 FROM NBR_REPORT500 t2\n" +
                    "\t\tWHERE t1.block_id = t2.block_id AND t1.flag500 = t2.flag)\n" +
                    "\t\tAND block_id NOT IN (SELECT block_id FROM NBR_REPORT1000)\n" +
                    "\tORDER BY qtyRange";
            return entityManager.createNativeQuery(query, NbrReportN16.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
