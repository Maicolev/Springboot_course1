package com.bagofideas.springboot.di.app.models.domain;

public class Item
{
    private Product product;
    private Integer quantity;

    public Item(Product product, Integer quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }
}
