package com.angel.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.angel.springboot.di.app.springboot_di.repositories.IProductRepository;
import com.angel.springboot.di.app.springboot_di.repositories.ProductRepositoyJson;

@Configuration
@PropertySources({
    @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
})
public class ValuesConfig {

    @Bean("productJson")
    IProductRepository productRepositoryJson (){
        return new ProductRepositoyJson();
    }

}
