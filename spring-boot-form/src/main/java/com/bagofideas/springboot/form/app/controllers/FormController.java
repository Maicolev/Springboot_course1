package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.models.domain.User;
import com.bagofideas.springboot.form.app.validation.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController
{
    @Autowired
    private UserValidate validator;

    @InitBinder
    public void initBinder(WebDataBinder binder){binder.addValidators(validator);}

    @GetMapping("/form")
    public String form(Model model)
    {
        User user = new User();
        user.setId("111.444.234-K");
        user.setName("Andrés");
        user.setLastName("Perez");
        model.addAttribute("title", "Users form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String process(@Valid User user, BindingResult validationResult, Model model, SessionStatus status)
    {
        //validator.validate(user,validationResult);

        model.addAttribute("title", "Form result");

        if(validationResult.hasErrors()) { return "form"; }

        model.addAttribute("user", user);
        status.setComplete();
        return "result";
    }
}
