package com.angel.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.angel.springboot.di.app.springboot_di.models.Product;

@Repository("productFoo")
public class ProductRepositoryFooImpl implements IProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1l, "Monitor ASUS 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        
        return new Product(id, "Monitor ASUS 27", 600L);
    }

    

}
