package com.example.javastreamdemo.demo3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by devinlee on 2021.02.22
 */
public class Main {

    public static void main(String[] args) {

        Community hdb = new Community("黄渠头路", "海德堡", 2000);
        Community yglz = new Community("黄渠头路", "阳光丽兹", 1500);
        Community tdzy = new Community("黄渠头路", "唐顿庄园", 1000);
        Community qjld = new Community("雁翔路", "曲江龙邸", 1000);
        List<Student> students = Arrays.asList(
                new Student("小黑", 5, Gender.MALE, hdb),
                new Student("小白", 6, Gender.FEMALE, hdb),
                new Student("小红", 7, Gender.FEMALE, yglz),
                new Student("小蓝", 5, Gender.MALE, tdzy),
                new Student("小陈", 3, Gender.FEMALE, hdb),
                new Student("小张", 3, Gender.MALE, yglz),
                new Student("小吴", 5, Gender.MALE, hdb),
                new Student("小刘", 12, Gender.FEMALE, hdb),
                new Student("大牛", 16, Gender.MALE, qjld),
                new Student("大李", 15, Gender.MALE, hdb),
                new Student("大Q", 42, Gender.FEMALE, qjld),
                new Student("大E", 35, Gender.MALE, hdb)
        );

        /**
         * 1、汇总小区名为 海德堡 的学生的总数:7
         * 2、汇总小区名为 海德堡 的学生的姓名集合
         * 3、住在 阳光丽兹 的学生的平均年龄为:5.0岁
         * 4、所有学生平均年龄:12.833333333333334
         * 5、大于平均年龄的学生有:[大Q, 大E, 大李, 大牛]
         */
        System.out.println(students.stream().filter(o -> o.getCommunity().getName().equalsIgnoreCase("海德堡")).count());

        System.out.println(students.stream().filter(o -> o.getCommunity().getName().equalsIgnoreCase("海德堡")).map(Student::getName).collect(Collectors.toList()));

        System.out.println(students.stream().filter(o -> o.getCommunity().getName().equalsIgnoreCase("阳光丽兹")).collect(Collectors.averagingInt(Student::getAge)));

        System.out.println(students.stream().collect(Collectors.averagingDouble(Student::getAge)));

        System.out.println(students.stream().filter(o -> o.getAge() > students.stream().collect(Collectors.averagingLong(Student::getAge))).map(Student::getName).collect(Collectors.toList()));
    }
}
