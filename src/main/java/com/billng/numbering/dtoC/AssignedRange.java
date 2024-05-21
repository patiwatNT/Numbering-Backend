package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class AssignedRange {
    String blockStart;
    String blockEnd;
    String blockArea;
    String selectedLocation;
    int blockId;
    int providerId;
    String empCode;
    int assignedId;
}
