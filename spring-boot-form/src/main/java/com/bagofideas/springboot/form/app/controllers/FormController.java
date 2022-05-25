package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.models.domain.User;
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
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);

        model.addAttribute("title", "Form result");
        model.addAttribute("userName", user);

        return "result";
    }
}
