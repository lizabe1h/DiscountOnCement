package com.example;

import com.example.util.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ReaderFile().read("discount_day.txt");
        List<Order> orders = lines.stream()
                .map(l -> l.split("\\|"))
                .map(parts -> new Order(new Company(parts[1]), LocalDateTime.parse(parts[0]), Double.parseDouble(parts[2]), 10.0))
                .sorted(Comparator.comparing(Order::getDateTime))
                .toList();

        System.out.println("Kоличество заказов " + orders.size());

        System.out.println();
        orders.forEach(System.out::println);
        System.out.println();
        System.out.println("============");
        OrderProcessor orderProcessor = new OrderProcessor();
        IDiscount strategy = new CementDiscount();
        orderProcessor.assignDiscount(orders, strategy);
        orders.forEach(System.out::println);

        System.out.println();
        System.out.println("Информация о компаниях: ");
        Map<String, Double> totals = orderProcessor.calculateTotals(orders);
        totals.forEach((name, sum) -> System.out.println(name + " - " + sum));

        FinalInformation finalInformation = new FinalInformation();
        finalInformation.writeFile(totals, "result.txt");
        System.out.println();
        System.out.println("Файл записан - result.txt");


    }
}
