package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.TOTServiceCenterDto;
import com.billng.numbering.dtoC.ServiceCenterTemp;

import java.util.List;

public interface TOTServiceCenterRepositoryCustom {
    TOTServiceCenterDto findByLocationCode(String locationCode);

    List<ServiceCenterTemp> findServiceCenter();

    List<String> findSector();
}
