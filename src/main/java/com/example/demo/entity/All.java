/**
 * @author Xiaohan Chen
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class All {
    private String firstname;

    private String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String symbol;

    private int quantity;
    @JsonFormat(pattern="YYYY-MM-dd", timezone = "GMT+8")
    private Date date;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
        return "All{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", symbol='" + symbol + '\'' +
                ", quantity='" + quantity + '\'' +
                ", date=" + date +
                '}';
    }
}
