package com.billng.numbering.repositoryCustom;

import com.billng.numbering.dtoC.DataExport;

import java.util.List;

public interface NumberingDataExportRepositoryCustom {
   List<DataExport> exportData(String providerId);
}
