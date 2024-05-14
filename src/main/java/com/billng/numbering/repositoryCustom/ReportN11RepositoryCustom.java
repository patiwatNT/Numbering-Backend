package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dtoC.ReportN11Active;
import com.billng.numbering.dtoC.ReportN11InactiveAndInProgress;

import java.util.List;

public interface ReportN11RepositoryCustom {
    List<ReportN11Active> findAllReportActive();
    List<ReportN11InactiveAndInProgress> findAllReportInactive();
    List<ReportN11InactiveAndInProgress> findAllReportInProgress();
}
