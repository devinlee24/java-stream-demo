package com.example.javastreamdemo.demo3;

/**
 * Created by devinlee on 2021.02.22
 */
public class Student {
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private Gender gender;
    // 小区
    private Community community;

    public Student(String name, int age, Gender gender, Community community) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", community=" + community +
                '}';
    }
}
