package com.bagofideas.springboot.datajpa.app.models.dao;

import com.bagofideas.springboot.datajpa.app.models.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDao extends CrudRepository<Customer, Long>
{

}
