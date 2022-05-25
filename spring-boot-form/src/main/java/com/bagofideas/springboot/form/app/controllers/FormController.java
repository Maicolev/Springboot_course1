package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public String process(@Valid User user, BindingResult validationResult, Model model)
    {
        model.addAttribute("title", "Form result");

        if(validationResult.hasErrors())
        {
            Map<String, String> errors = new HashMap<>();
            validationResult.getFieldErrors().forEach(err ->
            {
                errors.put(err.getField(),"The field ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });

            model.addAttribute("error", errors);
            return "form";
        }

        model.addAttribute("user", user);

        return "result";
    }
}
