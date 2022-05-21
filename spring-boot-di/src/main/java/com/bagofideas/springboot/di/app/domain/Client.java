package com.bagofideas.springboot.di.app.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client
{
    @Value("${client.name}")
    private String name;

    @Value("${client.lastName}")
    private String lastName;
}
