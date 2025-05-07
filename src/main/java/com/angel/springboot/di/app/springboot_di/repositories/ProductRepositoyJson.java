package com.angel.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import com.angel.springboot.di.app.springboot_di.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoyJson implements IProductRepository{

    private List<Product> list;



    public ProductRepositoyJson() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
           e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElseThrow();
    }

    

}
