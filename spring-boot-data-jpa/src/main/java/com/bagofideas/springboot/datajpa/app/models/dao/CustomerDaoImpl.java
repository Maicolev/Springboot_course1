package com.bagofideas.springboot.datajpa.app.models.dao;

import com.bagofideas.springboot.datajpa.app.models.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll()
    {
        return entityManager.createQuery("from Customer").getResultList();
    }

    @Override
    public Customer findOne(Long id)
    {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer)
    {
        if(customer.getId() != null && customer.getId() > 0 )
        {
            entityManager.merge(customer);
        }
        else
        {
            entityManager.persist(customer);
        }
    }

    @Override
    public void delete(Long id)
    {
        entityManager.remove(findOne(id));
    }
}
