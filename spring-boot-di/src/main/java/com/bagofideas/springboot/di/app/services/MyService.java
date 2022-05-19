package com.bagofideas.springboot.di.app.services;

import org.springframework.stereotype.Component;

@Component("MySimpleService")
public class MyService implements IService
{
    @Override
    public String operation()
    {
        return "execute important process";
    }
}
