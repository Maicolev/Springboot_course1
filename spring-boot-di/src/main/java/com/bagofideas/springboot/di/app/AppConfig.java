package com.bagofideas.springboot.di.app;

import com.bagofideas.springboot.di.app.models.domain.Item;
import com.bagofideas.springboot.di.app.models.domain.Product;
import com.bagofideas.springboot.di.app.models.services.IService;
import com.bagofideas.springboot.di.app.models.services.MyService;
import com.bagofideas.springboot.di.app.models.services.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig
{
    @Primary
    @Bean("MySimpleService")
    public IService registerMyService()
    {
        return new MyService();
    }

    @Bean("MyComplexService")
    public IService registerMyServiceComplex()
    {
        return new MyServiceComplex();
    }

    @Bean("invoiceItems")
    public List<Item> registerItems()
    {
        Product product1 = new Product("Sony camera", 100.00);
        Product product2 = new Product("Bicycle Bianchi aro 26", 200.00);

        Item linea1 = new Item(product1, 4);
        Item linea2 = new Item(product2, 2);

        return Arrays.asList(linea1,linea2);
    }

}
