package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController
{
    @GetMapping("/form")
    public String form(Model model)
    {
        User user = new User();
        user.setId(12313);
        user.setName("Andrés");
        user.setLastName("Perez");
        model.addAttribute("title", "Users form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String process(@Valid User user, BindingResult validationResult, Model model)
    {
        model.addAttribute("title", "Form result");

        if(validationResult.hasErrors()) { return "form"; }

        model.addAttribute("user", user);

        return "result";

    }
}
