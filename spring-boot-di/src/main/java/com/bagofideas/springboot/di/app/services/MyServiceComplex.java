package com.bagofideas.springboot.di.app.services;

import org.springframework.stereotype.Component;

//@Component("MyComplexService")
public class MyServiceComplex implements IService
{
    @Override
    public String operation()
    {
        return "execute important complex process";
    }
}
