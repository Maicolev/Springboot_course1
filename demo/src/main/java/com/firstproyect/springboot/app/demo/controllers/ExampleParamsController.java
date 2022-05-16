package com.firstproyect.springboot.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ExampleParamsController
{
    @GetMapping("/")
    public String index()
    {
        return "params/index";
    }
    @GetMapping("/string")
    public String param (@RequestParam(name = "text",required = false) String text, Model model)
    {
        model.addAttribute("result", "this is the text sent: "+text);
        return "params/view";
    }

    @GetMapping("/mix-params")
    public String param (@RequestParam String greeting, @RequestParam Integer number, Model model)
    {
        model.addAttribute("result", "The greeting sent is :'" + greeting + "'And the number is '" + number+ "'");
        return "params/view";
    }

    @GetMapping("/mix-params-request")
    public String param (HttpServletRequest request, Model model)
    {
        String greeting = request.getParameter("greeting");
        int number = 0;
        try
        {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e)
        {
            e.printStackTrace() ;
        }

        model.addAttribute("result", "The greeting sent is :'" + greeting + "'And the number is '" + number+ "'");
        return "params/view";
    }
}
