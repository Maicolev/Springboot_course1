package com.bagofideas.springboot.di.app;

import com.bagofideas.springboot.di.app.services.IService;
import com.bagofideas.springboot.di.app.services.MyService;
import com.bagofideas.springboot.di.app.services.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
}
