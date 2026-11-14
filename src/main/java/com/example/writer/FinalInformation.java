package com.example.writer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class FinalInformation {
    public void writeFile(Map<String, Double> totals, String path) throws IOException {
        List<String> lines = totals.entrySet().stream()
                .map(entry -> entry.getKey() + "  -  " + entry.getValue())
                .toList();

        Files.write(Path.of(path), lines);
    }
}
