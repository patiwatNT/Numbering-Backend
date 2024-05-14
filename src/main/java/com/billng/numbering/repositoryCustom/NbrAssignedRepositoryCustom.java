package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dto.NbrAssignedDto;
import com.billng.numbering.dtoC.AssignedRangeDtoC;
import com.billng.numbering.dtoC.NbrAssignedAmount;

import java.util.List;

public interface NbrAssignedRepositoryCustom {
    NbrAssignedDto findByAssignedId(String id);

    int countAssignedByProviderId(int providerId);

    int sumAssignedQtyByProviderId(int providerId);

    List<NbrAssignedDto> findByCriteria(String query);

    List<String> findAssignedRegion();

    List<String> findAssignedSector();

    List<NbrAssignedAmount> findAssignedAmount(String query);

}
