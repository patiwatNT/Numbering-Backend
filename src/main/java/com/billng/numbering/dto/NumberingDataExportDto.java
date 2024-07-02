package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

@ApiModel()
public class NumberingDataExportDto extends AbstractDto<String> {
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String data;
    @Size(max = 255)
    private String fileName;
    @Size(max = 255)
    private String encode;
    @Size(max = 255)
    private String columnDelimiter;
    @Size(max = 255)
    private String fieldName;

    public NumberingDataExportDto() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getEncode() {
        return this.encode;
    }

    public void setColumnDelimiter(String columnDelimiter) {
        this.columnDelimiter = columnDelimiter;
    }

    public String getColumnDelimiter() {
        return this.columnDelimiter;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}