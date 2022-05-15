package com.firstproyect.springboot.app.demo.controllers;

import com.firstproyect.springboot.app.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    //Request mapping = getMapping = Post Mapping
    //@GetMapping(value="/index")
    @GetMapping({"", "/index", "/", "/home"})
    public String index(Model model)
    {
        model.addAttribute("title", "Data passed successful");
        return "index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        User userCreated = new User();
        userCreated.setName("Alberto");
        userCreated.setLastName("Grisales");
        userCreated.setEmail("alberto.grisales@test.com");


        model.addAttribute("userCreated", userCreated);
        model.addAttribute("title", "User profile:".concat(userCreated.getName().concat(" ").concat(userCreated.getLastName())));

        return "profile";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = Arrays.asList(
                new User("Alberto","Grisales","alberto.grisales@test.com"),
                new User("Juana","Pabón","juana.pabon@test.com"),
                new User("Sandra","Saint","sandra.saint@test.com"),
                new User("Angie","Ramirez","angie.ramirez@test.com"));

        model.addAttribute("users", users);
        model.addAttribute("title", "list of users");
        return "list";
    }

}
