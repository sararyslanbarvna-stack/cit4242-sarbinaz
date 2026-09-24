package com.example.demo.entity;

public record Book(String title, String author, int pages) {

    // Domain decision kept (not simple bookkeeping)
    public boolean isThick() {
        return pages > 400;
    }
}