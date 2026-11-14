package com.example.service;


import com.example.discount.IDiscount;
import com.example.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessor {

    public void assignDiscount(List<Order> orders, IDiscount discountStrategy) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            int position = i + 1;
            double discount = discountStrategy.calculateDiscount(position);
            order.setDiscount(discount);
        }
    }

    public Map<String, Double> calculateTotals(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCompany().getName(), Collectors.summingDouble(o -> o.getTotalSum())
                ));
    }
}
