package com.example.reader;

import com.example.model.Company;
import com.example.model.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;



public abstract class AbstractOrderReader implements IOrderReader {
   public abstract String getDelimiter();

    @Override
    public List<Order> read(String pathFile, double priceKg) throws IOException {
        return Files.lines(Path.of(pathFile))
                .map(line -> line.split(getDelimiter()))
                .map(parts -> new Order(
                        new Company(parts[1]),                  // 1 — компания
                        LocalDateTime.parse(parts[0]),          // 2 — время
                        Double.parseDouble(parts[2]),           // 3 — кг
                        priceKg                                 // 4 — цена
                ))
            .toList();
    }
}
