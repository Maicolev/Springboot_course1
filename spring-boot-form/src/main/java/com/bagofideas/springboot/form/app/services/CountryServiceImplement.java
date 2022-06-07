package com.bagofideas.springboot.form.app.services;

import com.bagofideas.springboot.form.app.models.domain.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImplement implements CountryService
{
    private List<Country> list;

    public CountryServiceImplement() {
        this.list = Arrays.asList(
                new Country(1, "ES", "España"),
                new Country(2, "MX", "México"),
                new Country(3, "CL", "Chile"),
                new Country(4, "AR", "Argentina"),
                new Country(5, "PE", "Perú"),
                new Country(6, "CO", "Colombia"),
                new Country(7, "VE", "Venezuela"));
    }

    @Override
    public List<Country> toList() {
        return list;
    }

    @Override
    public Country getById(Integer id) {
        Country result = null;
        for(Country country: this.list) {
            if(id == country.getId()) {
                result = country;
                break;
            }
        }
        return result;
    }

}
