package com.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderFile {
    public List<String> read(String text) throws IOException {
        return Files.readAllLines(Path.of(text));
    }

}
