package com.bagofideas.springboot.di.app.models.services;

//@Primary
//@Component("MySimpleService")
public class MyService implements IService
{
    @Override
    public String operation()
    {
        return "execute important simple process";
    }
}
