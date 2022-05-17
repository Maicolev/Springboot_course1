package com.firstproyect.springboot.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExampleVariablePath
{
    @GetMapping("/")
    public String index (Model model)
    {
        model.addAttribute("title", "Sent route parameters");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model)
    {
        model.addAttribute("title", "Receive route parameters");
        model.addAttribute("result", "The text sent on the route it's: " + text);
        return "variables/view";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model)
    {
        model.addAttribute("title", "Receive route parameters");
        model.addAttribute("result", "The text sent on the route it's: " + text + " The number sent on the route it's: " + number);
        return "variables/view";
    }
}
