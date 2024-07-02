package com.billng.numbering.repositoryCustom.Impl;

import com.billng.numbering.dtoC.DataExport;
import com.billng.numbering.dtoC.NbrAssignedAmount;
import com.billng.numbering.entities.NumberingDataExport;
import com.billng.numbering.mapper.NbrAssignedMapper;
import com.billng.numbering.mapper.NumberingDataExportMapper;
import com.billng.numbering.repositoryCustom.NumberingDataExportRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NumberingDataExportRepositoryCustomImpl implements NumberingDataExportRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<DataExport> exportData(String providerId) {
        try{
            String query = "SELECT \n" +
                    "    SN.service_no service_no,\n" +
                    "    CASE \n" +
                    "        WHEN B.provider_id = 1 THEN AG.station_name_en\n" +
                    "        WHEN B.provider_id = 2 THEN ISNULL(AG.station_name_en, 'TT&T')\n" +
                    "        WHEN B.provider_id = 3 THEN ISNULL(AG.station_name_en, 'TRUE')\n" +
                    "    END exch_name_english,\n" +
                    "    CASE \n" +
                    "        WHEN B.provider_id = 1 THEN AG.station_name_th\n" +
                    "        WHEN B.provider_id = 2 THEN ISNULL(AG.station_name_th, 'TT&T')\n" +
                    "        WHEN B.provider_id = 3 THEN ISNULL(AG.station_name_th, 'TRUE')\n" +
                    "    END exch_name_thai,\n" +
                    "    SN.location_code service_location\n" +
                    "FROM \n" +
                    "    NBR_SERVICE_NUMBERS SN\n" +
                    "LEFT JOIN \n" +
                    "    NBR_ASSIGNED AG ON SN.assigned_id = AG.assigned_id\n" +
                    "LEFT JOIN \n" +
                    "    NBR_BLOCKS B ON SN.block_id = B.block_id\n" +
                    "WHERE \n" +
                    "    B.provider_id = "+providerId+"\n" +
                    "    AND B.block_status IN (1, 2)\n" +
                    "GROUP BY \n" +
                    "    SN.service_no, \n" +
                    "    B.provider_id, \n" +
                    "    AG.station_name_en, \n" +
                    "    AG.station_name_th, \n" +
                    "    SN.location_code";
            return entityManager.createNativeQuery(query, DataExport.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
