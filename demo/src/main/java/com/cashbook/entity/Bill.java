package com.cashbook.entity;

import java.math.BigDecimal;

public class Bill {
    private int id;// id
    private String name;// 消费名称
    private BigDecimal amount;// 消费金额
    private String date;// 消费日期
    private BigDecimal sum;// 累计消费

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Bill [id=" + id + ", name=" + name + ", money=" + amount + ", date=" + date + ", sum=" + sum + "]";
    }

    public Bill() {
    }

    public Bill(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public Bill(int id, String name, BigDecimal amount, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public Bill(int id, String name, BigDecimal amount, String date, BigDecimal sum) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.sum = sum;
    }
}
