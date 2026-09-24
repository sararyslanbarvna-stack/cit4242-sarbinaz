package com.example.demo.controller;

import com.example.demo.service.DynamicColumnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final DynamicColumnService dynamicColumnService;


    public UserController(DynamicColumnService dynamicColumnService) {
        this.dynamicColumnService = dynamicColumnService;
    }


    @GetMapping("/column")
    public List<String> getColumnValues(@RequestParam String name) {
        return dynamicColumnService.getColumnValues(name);
    }

}