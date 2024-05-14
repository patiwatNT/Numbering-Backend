package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dtoC.NbrReportN16;

import java.util.List;

public interface NbrReport1000RepositoryCustom {
    List<NbrReportN16> findReportN16Inc();

    List<NbrReportN16> findReportN16Only();
}
