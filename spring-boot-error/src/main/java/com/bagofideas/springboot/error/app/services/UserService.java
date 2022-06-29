package com.bagofideas.springboot.error.app.services;

import com.bagofideas.springboot.error.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    public List<User> toList();

    public User getById(Integer id);

    public Optional<User> getByOptionalId(Integer id);

}
