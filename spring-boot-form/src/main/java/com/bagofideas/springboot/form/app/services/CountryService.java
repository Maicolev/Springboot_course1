package com.bagofideas.springboot.form.app.services;

import com.bagofideas.springboot.form.app.models.domain.Country;

import java.util.List;

public interface CountryService
{

    public List<Country> toList();
    public Country getById(Integer id);
}
