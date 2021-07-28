package com.lovecoding.web.bean;

import java.io.Serializable;

public class CartAndProduct implements Serializable{
    private String pimage;
    private String pname;

    private Double shopPrice;
    private Integer count;
    private Double realPrice;

    private Integer id;

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public String toString() {
        return "CartAndProduct{" +
                "pimage='" + pimage + '\'' +
                ", pname='" + pname + '\'' +
                ", shopPrice=" + shopPrice +
                ", count=" + count +
                ", realPrice=" + realPrice +
                ", id=" + id +
                '}';
    }
}
