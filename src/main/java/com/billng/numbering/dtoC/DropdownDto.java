package com.billng.numbering.dtoC;

import lombok.Data;

import java.util.List;

@Data
public class DropdownDto {
    private String label;
    private String value;
    private List<ItemGroup> items;
}
