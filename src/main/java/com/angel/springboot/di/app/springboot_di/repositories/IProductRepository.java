package com.angel.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.angel.springboot.di.app.springboot_di.models.Product;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
