package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String process(User user, Model model)
    {
        model.addAttribute("title", "Form result");
        model.addAttribute("user", user);

        return "result";
    }
}
