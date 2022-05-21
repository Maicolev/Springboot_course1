package com.bagofideas.springboot.di.app.controllers;

import com.bagofideas.springboot.di.app.models.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
    @Autowired
    @Qualifier("MyComplexService")
    private IService service;

    @GetMapping({"/", "", "/index"})
    public String index(Model model)
    {
        model.addAttribute("object", service.operation());
        return "index";
    }
}
