package com.bagofideas.springboot.di.app.models.services;

//@Component("MyComplexService")
public class MyServiceComplex implements IService
{
    @Override
    public String operation()
    {
        return "execute important complex process";
    }
}
