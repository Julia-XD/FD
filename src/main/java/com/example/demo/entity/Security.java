package com.example.demo.entity;

public class Security {
    private Integer securityId;

    private String symbol;

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", securityId=").append(securityId);
        sb.append(", symbol=").append(symbol);
        sb.append("]");
        return sb.toString();
    }
}