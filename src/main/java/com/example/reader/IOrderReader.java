package com.example.reader;

import com.example.model.Order;

import java.io.IOException;
import java.util.List;

public interface IOrderReader {
    List<Order> read (String pathFile,double priceKg) throws IOException;
}
