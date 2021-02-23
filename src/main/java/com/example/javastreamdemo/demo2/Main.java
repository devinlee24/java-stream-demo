package com.example.javastreamdemo.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by devinlee on 2021.02.22
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("一、给定一个数字列表，如何返回一个由每个数的平方构成的列表？给定【1，2，3，4，5】，返回【1，4，9，16，25】");
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numList.stream().map(o -> o * o).sorted((o2, o1) -> o2.compareTo(o1)).collect(Collectors.toList()));

        System.out.println("二、怎么用map和reduce方法数一数流中有多少个Employee？");
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("李四", 50, 5555.99),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 3333.33),
                new Employee("田七", 8, 7777.77)
        );
        System.out.println(employees.stream().count());
        System.out.println(employees.stream().map(o -> 1).reduce(0, (o1, o2) -> o1 + o2).intValue());

        System.out.println("三、根据“交易员类”和“交易类”完成相应的功能");
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）");
        transactions.stream().filter(o -> o.getYear() == 2011).sorted((o1, o2) -> o1.getValue() - o2.getValue()).forEach(System.out::println);

        System.out.println("2.交易员都在哪些不同的城市工作过？");
        transactions.stream().map(o -> o.getTrader().getCity()).distinct().forEach(System.out::println);

        System.out.println("3. 查找所有来自剑桥的交易员，并按姓名排序");
        transactions.stream().map(Transaction::getTrader).filter(o -> o.getCity().equalsIgnoreCase("Cambridge")).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);

        System.out.println("4. 返回所有交易员的姓名字符串，按字母顺序排序");
        transactions.stream().map(o -> o.getTrader().getName()).sorted((o1, o2) -> o1.compareTo(o2)).distinct().forEach(System.out::println);

        System.out.println("5. 有没有交易员是在米兰工作的？");
        System.out.println(transactions.stream().anyMatch(o -> o.getTrader().getCity().equalsIgnoreCase("Milan")));

        System.out.println("6. 打印生活在剑桥的交易员的所有交易额");
        System.out.println(transactions.stream().filter(o -> o.getTrader().getCity().equalsIgnoreCase("Cambridge")).collect(Collectors.summingInt(Transaction::getValue)));

        System.out.println("7. 所有交易中，最高的交易额是多少");
        System.out.println(transactions.stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).findFirst().get().getValue());
        System.out.println(transactions.stream().map(Transaction::getValue).max((o1, o2) -> o1 - o2).get().intValue());
        System.out.println(transactions.stream().map(Transaction::getValue).collect(Collectors.maxBy((o1, o2) -> o1 - o2)).get().intValue());

        System.out.println("8. 找到交易额最小的交易");
        System.out.println(transactions.stream().map(Transaction::getValue).collect(Collectors.maxBy((o1, o2) -> o2 - o1)).get().intValue());
    }
}
