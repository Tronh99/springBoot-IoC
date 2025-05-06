package com.angel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.angel.springboot.di.app.springboot_di.models.Product;
import com.angel.springboot.di.app.springboot_di.repositories.IProductRepository;


@Service
public class ProductServicesImpl implements IProductServices {



    @Autowired
    private Environment environment;
    private IProductRepository repository;
    @Autowired
    public void setRepository(@Qualifier("productList") IProductRepository repository) {
        this.repository = repository;
    }
    

    @Override
    public List<Product> findAll() {
        

        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("coanfig.price.tax", Double.class);
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
//          p.setPrice(priecTax.longValue());
//          return p;   
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }


}
