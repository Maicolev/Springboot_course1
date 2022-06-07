package com.bagofideas.springboot.form.app.services;

import com.bagofideas.springboot.form.app.models.domain.Role;

import java.util.List;

public interface RoleService
{

    public List<Role> toList();
    public Role getById(Integer id);
}
