package com.example.javastreamdemo.demo3;

/**
 * Created by devinlee on 2021.02.22
 */
public class  Community {
    private String address;
    private String name;
    private int count; // 小区人数

    public Community(String address, String name, int count) {
        this.address = address;
        this.name = name;
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
