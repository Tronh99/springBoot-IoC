package com.angel.springboot.di.app.springboot_di.services;

import java.util.List;

import com.angel.springboot.di.app.springboot_di.models.Product;

public interface IProductServices {

    public List<Product> findAll();

    public Product findById(Long id);

}
