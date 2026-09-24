package com.example.demo.repository;

import com.example.demo.entity.Book;
import java.util.List;

public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Clean Code", "Robert C. Martin", 464),
                new Book("Effective Java", "Joshua Bloch", 412),
                new Book("Design Patterns", "Erich Gamma", 395)
        );
    }
}