package com.bagofideas.springboot.datajpa.app.models.dao;

import com.bagofideas.springboot.datajpa.app.models.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional//(readOnly = true)
    public List<Customer> findAll()
    {
        return entityManager.createQuery("from Customer").getResultList();
    }

    @Override
    @Transactional//(readOnly = true)
    public Customer findOne(Long id)
    {
        return entityManager.find(Customer.class, id);
    }

    @Override
    @Transactional
    public void save(Customer customer)
    {
        if(customer.getId() > 0 && customer.getId() != null)
        {
            entityManager.merge(customer);
        }
        else
        {
            entityManager.persist(customer);
        }
    }

    @Override
    @Transactional
    public void delete(Long id)
    {
        entityManager.remove(findOne(id));
    }
}
