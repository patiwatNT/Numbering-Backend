package com.billng.numbering.dto;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class EmployeeDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Max(Integer.MAX_VALUE)
    private Integer id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String age;

    public EmployeeDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return this.age;
    }
}