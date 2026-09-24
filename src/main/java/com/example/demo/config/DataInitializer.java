package com.example.demo.config;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        entityManager.persist(new User("Иван", "Иванов", "ivan@mail.com"));
        entityManager.persist(new User("Анна", "Петрова", "anna@mail.com"));
        entityManager.persist(new User("Олег", "Сидоров", "oleg@mail.com"));
    }
}