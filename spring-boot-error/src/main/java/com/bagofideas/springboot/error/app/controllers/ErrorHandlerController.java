package com.bagofideas.springboot.error.app.controllers;

import com.bagofideas.springboot.error.app.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController
{
    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticError(ArithmeticException ex, Model model)
    {
        model.addAttribute("error", "Arithmetic error");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/generic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatError(ArithmeticException ex, Model model)
    {
        model.addAttribute("error", "Invalid number format");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/format-number";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundError(ArithmeticException ex, Model model)
    {
        model.addAttribute("error", "Error: user not found");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/user";
    }
}
