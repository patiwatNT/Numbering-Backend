package com.billng.numbering.dto;

import com.billng.numbering.entities.ServiceLocationPK;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@ApiModel()
public class ServiceLocationDto extends AbstractDto<ServiceLocationPK> {
    private ServiceLocationPK serviceLocationPK;
    @Size(max = 255)
    private String name;

    public ServiceLocationDto() {
    }

    public void setServiceLocationPK(ServiceLocationPK serviceLocationPK) {
        this.serviceLocationPK = serviceLocationPK;
    }

    public ServiceLocationPK getServiceLocationPK() {
        return this.serviceLocationPK;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}