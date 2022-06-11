package com.bagofideas.springboot.form.app.controllers;

import com.bagofideas.springboot.form.app.edits.CountryPropertyEdits;
import com.bagofideas.springboot.form.app.edits.RoleEdits;
import com.bagofideas.springboot.form.app.edits.UpperCaseEdits;
import com.bagofideas.springboot.form.app.models.domain.Country;
import com.bagofideas.springboot.form.app.models.domain.Role;
import com.bagofideas.springboot.form.app.models.domain.User;
import com.bagofideas.springboot.form.app.services.CountryService;
import com.bagofideas.springboot.form.app.services.RoleService;
import com.bagofideas.springboot.form.app.validation.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController
{
    @Autowired
    private UserValidate validator;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CountryPropertyEdits countryEditor;

    @Autowired
    private RoleEdits roleEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.addValidators(validator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,"birthday" ,new CustomDateEditor(dateFormat,true));

        binder.registerCustomEditor(String.class, "name", new UpperCaseEdits());
        binder.registerCustomEditor(String.class, "lastName", new UpperCaseEdits());

        binder.registerCustomEditor(Country.class, "country", countryEditor);
        binder.registerCustomEditor(Role.class, "roles", roleEditor);
    }
    @ModelAttribute("gender")
    public List<String> gender(){
        return Arrays.asList("Man", "Woman");
    }

    @ModelAttribute("rolesList")
    public List<Role> listaRoles(){
        return this.roleService.toList();
    }

    @ModelAttribute("countryList")
    public List<Country> countryList() {
        return countryService.toList();
    }

    @ModelAttribute("rolesStringList")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("rolesMapList")
    public Map<String, String> listaRolesMap() {
        Map<String, String> roles = new HashMap<String, String>();
        roles.put("ROLE_ADMIN", "Administrator");
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_MODERATOR", "Moderator");

        return roles;
    }

    @ModelAttribute("Countries")
    public List<String> Countries() {
        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> countriesMap() {
        Map<String, String> countries = new HashMap<String, String>();
        countries.put("ES", "España");
        countries.put("MX", "México");
        countries.put("CL", "Chile");
        countries.put("AR", "Argentina");
        countries.put("PE", "Perú");
        countries.put("CO", "Colombia");
        countries.put("VE", "Venezuela");
        return countries;
    }

    @GetMapping("/form")
    public String form(Model model)
    {
        User user = new User();
        user.setId("11.444.234-K");
        user.setName("Andrés");
        user.setLastName("Perez");
        user.setEnable(true);
        user.setSecretValue("The secret value****");
        user.setCountry(new Country(3, "CL", "Chile"));
        user.setRoles(Arrays.asList(new Role(2, "User", "ROLE_USER")));


        model.addAttribute("title", "Users form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String process(@Valid User user, BindingResult result, Model model)
    {
        // validador.validate(usuario, result);

        if (result.hasErrors())
        {
            model.addAttribute("title", "Form result");
            return "form";
        }

        return "redirect:/view";
    }

    @GetMapping("/view")
    public String view(@SessionAttribute(name="user", required = false) User user, Model model, SessionStatus status)
    {

        if(user == null)
        {
            return "redirect:/form";
        }

        model.addAttribute("title", "Form result");

        status.setComplete();
        return "result";
    }
}
