package com.bagofideas.springboot.datajpa.app.models.services;

import com.bagofideas.springboot.datajpa.app.models.entities.Customer;

import java.util.List;

public interface ICustomerService
{
    public List<Customer> findAll();

    public Customer findOne(Long id);

    public void save(Customer customer);

    public void delete(Long id);
}
