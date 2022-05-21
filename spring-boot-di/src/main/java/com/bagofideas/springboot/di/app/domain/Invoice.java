package com.bagofideas.springboot.di.app.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice
{
    @Value("${invoice.description}")
    private String description;

    @Autowired
    private Client client;
    private List <Item> items;
}
