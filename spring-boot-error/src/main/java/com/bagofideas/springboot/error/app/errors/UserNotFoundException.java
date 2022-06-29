package com.bagofideas.springboot.error.app.errors;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String id)
    {
        super("User with ID: ".concat(id).concat("Does not exist in the system "));
    }
}
