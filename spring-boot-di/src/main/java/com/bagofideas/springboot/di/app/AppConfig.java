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

        Item line1 = new Item(product1, 4);
        Item line2 = new Item(product2, 2);

        return Arrays.asList(line1,line2);
    }

    @Primary
    @Bean("invoiceItemsOffice")
    public List<Item> registerItemsOffice()
    {
        Product product1 = new Product("Monitor LG LCD 24", 250.70);
        Product product2 = new Product("Notebook asus", 300.56);
        Product product3 = new Product("Multifunctional printer HP", 80.01);
        Product product4 = new Product("Office desktop", 100.50);

        Item line1 = new Item(product1, 2);
        Item line2 = new Item(product2, 2);
        Item line3 = new Item(product3, 1);
        Item line4 = new Item(product4, 1);

        return Arrays.asList(line1, line2,line3,line4);
    }

}
