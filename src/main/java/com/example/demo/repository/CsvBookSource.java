package com.example.demo.repository;

import com.example.demo.entity.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvBookSource implements BookSource {
    private final String resourcePath;

    public CsvBookSource(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public List<Book> load() {
        try {
            return Files.lines(Path.of(resourcePath))
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Book(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + resourcePath, e);
        }
    }
}