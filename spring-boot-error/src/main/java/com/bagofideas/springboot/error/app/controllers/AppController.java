package com.bagofideas.springboot.error.app.controllers;

import com.bagofideas.springboot.error.app.errors.UserNotFoundException;
import com.bagofideas.springboot.error.app.model.User;
import com.bagofideas.springboot.error.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController
{

    @Autowired
    private UserService userService;

    @SuppressWarnings("unused")
    @GetMapping("/index")
    public String index()
    {
        Integer valor = 100/0;
        //Integer valor2 = Integer.parseInt("10xx");
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view (@PathVariable Integer id, Model model)
    {
        //User user = userService.getById(id);

        /*if(user == null)
        {
            throw new UserNotFoundException(id.toString());
        }*/

        User user = userService.getByOptionalId(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

        model.addAttribute("user",user);
        model.addAttribute("title", "User detail: ".concat(user.getName()));

        return "view";
    }

}
