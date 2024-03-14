package com.billng.numbering.dto;

import com.billng.numbering.annotation.CheckDate;
import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.Size;

import java.util.Date;

@ApiModel()
public class NewsDto extends AbstractDto<Integer> {
    private long serialVersionUID;
    @Size(max = 255)
    private String id;
    @Size(max = 255)
    private String newsTitle;
    @Size(max = 255)
    private String newsDetail;
    @CheckDate
    private Date createDate;
    @Size(max = 255)
    private String createBy;
    @CheckDate
    private Date updateDate;
    @Size(max = 255)
    private String updateBy;

    public NewsDto() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle() {
        return this.newsTitle;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public String getNewsDetail() {
        return this.newsDetail;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }
}