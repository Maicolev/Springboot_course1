package com.bagofideas.springboot.di.app.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("MySimpleService")
public class MyService implements IService
{
    @Override
    public String operation()
    {
        return "execute important simple process";
    }
}
