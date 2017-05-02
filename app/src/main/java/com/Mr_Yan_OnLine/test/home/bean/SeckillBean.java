package com.Mr_Yan_OnLine.test.home.bean;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/5/2
 * 备注
 */

public class SeckillBean {

    /**
     * cover_price : 20.00
     * figure : /1478489000522.png
     * name : 商城购物节特供优惠券  满600-120优惠券
     * origin_price : 20.00
     * product_id : 7100
     */

    private String cover_price;
    private String figure;
    private String name;
    private String product_id;

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        this.cover_price = cover_price;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public SeckillBean(String cover_price, String figure, String name) {
        this.cover_price = cover_price;
        this.figure = figure;
        this.name = name;
    }
}
