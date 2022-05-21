package com.bagofideas.springboot.di.app.models.domain;

public class Product
{
    private String name;
    private Double price;

    public Product(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }
}
