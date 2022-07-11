package com.bagofideas.springboot.datajpa.app.models.services;

import com.bagofideas.springboot.datajpa.app.models.dao.ICustomerDao;
import com.bagofideas.springboot.datajpa.app.models.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ICustomerServiceImpl implements ICustomerService
{
    @Autowired
    private ICustomerDao customerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findOne(Long id) {
        return customerDao.findOne(id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        customerDao.delete(id);
    }
}
