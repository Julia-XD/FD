package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Position {
    private Integer positionId;

    private Integer securityId;

    private Integer fundId;

    private Integer quantity;
    @ApiModelProperty(hidden = true)
    private Date date;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", positionId=").append(positionId);
        sb.append(", securityId=").append(securityId);
        sb.append(", fundId=").append(fundId);
        sb.append(", quantity=").append(quantity);
        sb.append(", date=").append(date);
        sb.append("]");
        return sb.toString();
    }
}