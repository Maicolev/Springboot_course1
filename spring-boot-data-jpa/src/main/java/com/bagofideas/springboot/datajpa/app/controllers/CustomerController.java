package com.bagofideas.springboot.datajpa.app.controllers;

import com.bagofideas.springboot.datajpa.app.models.entities.Customer;
import com.bagofideas.springboot.datajpa.app.models.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("customer")
public class CustomerController
{
    @Autowired
    private ICustomerService customerService;

    @RequestMapping (value = "/toList", method = RequestMethod.GET)
    public String toList(Model model)
    {
        model.addAttribute("title", "Customer list");
        model.addAttribute("customers", customerService.findAll());
        return "toList";
    }

    @RequestMapping(value = "/form")
    public String create (Map<String, Object> model)
    {
        Customer customer = new Customer();
        model.put("customer",customer);
        model.put("title","Customer form");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash)
    {
        Customer customer = null;
        if(id>0)
        {
             customer = customerService.findOne(id);
             if(customer == null)
             {
                 flash.addFlashAttribute("error","Customer id doesn't exist in the DB ");
                 return "redirect:/toList";
             }
        }
        else
        {
            flash.addFlashAttribute("error","Customer id can't be zero ");
            return "redirect:/toList";
        }
        model.put("customer",customer);
        model.put("title","Customer edit");
        return "form";
    }

    @RequestMapping (value = "/form", method = RequestMethod.POST)
    public String save(@Valid Customer customer, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status)
    {
        if(result.hasErrors())
        {
            model.addAttribute("title", "Customer form");
            return "form";
        }

        String flashMessage = (customer.getId() != null)? "Customer modified successfully" : "Customer has been added successfully";

        customerService.save(customer);
        status.setComplete();
        flash.addFlashAttribute("success",flashMessage);
        return "redirect:toList";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id,RedirectAttributes flash)
    {
        if(id > 0)
        {
            customerService.delete(id);
            flash.addFlashAttribute("success","Customer has been deleted successfully");
        }
        return "redirect:/toList";
    }

}

