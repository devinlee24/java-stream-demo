package com.example.javastreamdemo.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by devinlee on 2021.02.22
 */
public class Main {

    public static void main(String[] args) {

        Property p1 = new Property("木桶饭", 1000, 500, 2);
        Property p2 = new Property("黄焖鸡", 2300, 1500, 3);
        Property p3 = new Property("麦当劳", 580, 3000, 1);
        Property p4 = new Property("肯德基", 6000, 200, 1);
        List<Property> properties = Arrays.asList(p1, p2, p3, p4);

        System.out.println("1、找到距离最近的店铺：");
        System.out.println(properties.stream().sorted((o1, o2) -> o1.getDistance().compareTo(o2.getDistance())).findFirst().get().getName());

        System.out.println("2、月销量大于1000的店铺个数：");
        System.out.println(properties.stream().filter(o -> o.getSales() >= 1000).count());
        System.out.println(properties.stream().filter(o -> o.getSales() >= 1000).collect(Collectors.counting()));
        System.out.println(properties.stream().filter(o -> o.getSales() >= 1000).collect(Collectors.summarizingInt(Property::getPriceLevel)).getCount());
        System.out.println(properties.stream().filter(o -> o.getSales() >= 1000).map(o -> 1).reduce(0, (a, b) -> a + b).intValue());

        System.out.println("3、获取距离最近的2个店铺：");
        System.out.println(properties.stream().sorted((o1, o2) -> o1.getDistance().compareTo(o2.getDistance())).limit(2).map(Property::getName).collect(Collectors.toList()));

        System.out.println("4、获取所有店铺的名称：");
        System.out.println(properties.stream().map(Property::getName).collect(Collectors.toList()));

        System.out.println("5、获取每个店铺的价格等级：");
        properties.stream().collect(Collectors.toMap(Property::getName, Property::getPriceLevel)).forEach((k, v) -> System.out.println(String.format("[店铺名：%s，价格等级：%d]", k, v)));

        System.out.println("6、所有价格等级的店铺列表：");
        System.out.println(properties.stream().collect(Collectors.groupingBy(Property::getPriceLevel)));
    }
}
