package com.bagofideas.springboot.datajpa.app.models.dao;

import com.bagofideas.springboot.datajpa.app.models.entity.Customer;

import java.util.List;

public interface ICustomerDao
{
    public List<Customer> findAll();

    public Customer findOne(Long id);

    public void save(Customer customer);

    public void delete(Long id);
}
