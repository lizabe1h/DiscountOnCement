package com.example;

import com.example.discount.CementDiscount;
import com.example.discount.IDiscount;
import com.example.model.Company;
import com.example.model.Order;
import com.example.reader.HashOrderReader;
import com.example.reader.IOrderReader;
import com.example.reader.PipeOrderReader;
import com.example.service.OrderProcessor;
import com.example.writer.FinalInformation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        IOrderReader pipeReader = new PipeOrderReader();
        IOrderReader hashReader = new HashOrderReader();

        List<Order> all = new ArrayList<>(); //адаптер чтение файлов
        all.addAll(pipeReader.read("discount_day.txt", 10.0));
        all.addAll(hashReader.read("discount_day_without_ext", 10.0));

        List<Order> orders = all.stream() //сортиров по времени
                .sorted(Comparator.comparing(Order::getDateTime))
                .toList();

        System.out.println("Kоличество заказов " + orders.size());

        OrderProcessor orderProcessor = new OrderProcessor();
        IDiscount strategy = new CementDiscount(); //cкидки
        orderProcessor.assignDiscount(orders, strategy);

        System.out.println("Информация о компаниях: ");
        Map<String, Double> totals = orderProcessor.calculateTotals(orders);
        totals.forEach((name, sum) -> System.out.println(name + " - " + sum));

        FinalInformation finalInformation = new FinalInformation();
        finalInformation.writeFile(totals, "result.txt");
        System.out.println();
        System.out.println("Файл записан - result.txt");



    }
}
