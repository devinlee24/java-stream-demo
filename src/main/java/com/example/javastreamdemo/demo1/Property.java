package com.example.javastreamdemo.demo1;

/**
 * 店铺类
 * Created by devinlee on 2021.02.22
 */
public class Property {

    private String  name;
    // 距离，单位:米
    private Integer distance;
    // 销量，月售
    private Integer sales;
    // 价格，这里简单起见就写一个级别代表价格段
    private Integer priceLevel;

    public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDistance() {
        return distance;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }
    public Integer getPriceLevel() {
        return priceLevel;
    }
    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }
    @Override
    public String toString() {
        return "Property [name=" + name + ", distance=" + distance + ", sales=" + sales + ", priceLevel=" + priceLevel
                + "]";
    }

}
