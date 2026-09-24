package com.example.demo.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DynamicColumnService {

    @PersistenceContext
    private EntityManager entityManager;

    // Whitelist allowed columns to prevent SQL injection
    private static final Set<String> ALLOWED_COLUMNS = Set.of("email", "first_name", "last_name");

    public List<String> getColumnValues(String columnName) {
        if (!ALLOWED_COLUMNS.contains(columnName)) {
            throw new IllegalArgumentException("Invalid column name: " + columnName);
        }

        String query = "SELECT " + columnName + " FROM users";
        return entityManager.createNativeQuery(query).getResultList();
    }
}