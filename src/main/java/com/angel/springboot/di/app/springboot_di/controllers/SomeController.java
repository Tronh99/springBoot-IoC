package com.angel.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.angel.springboot.di.app.springboot_di.models.Product;
import com.angel.springboot.di.app.springboot_di.services.ProductServicesImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")

public class SomeController {

    private ProductServicesImpl services = new ProductServicesImpl();

    @GetMapping

    public List<Product> list() {
        return services.findAll();

    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return services.findById(id);
    }

}
