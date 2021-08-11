package com.example.demo.entity;

public class Fund {
    private Integer fundId;

    private String name;

    private Integer employeeId;

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fundId=").append(fundId);
        sb.append(", name=").append(name);
        sb.append(", employeeId=").append(employeeId);
        sb.append("]");
        return sb.toString();
    }
}