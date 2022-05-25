package com.bagofideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController
{
    @GetMapping("/form")
    public String form(Model model)
    {
        model.addAttribute("title", "Users form");
        return "form";
    }

    @PostMapping("/form")
    public String process(Model model,
                          @RequestParam(name = "userName") String userName,
                          @RequestParam String password,
                          @RequestParam String email)
    {
        model.addAttribute("title", "Form result");
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        return "result";
    }
}
