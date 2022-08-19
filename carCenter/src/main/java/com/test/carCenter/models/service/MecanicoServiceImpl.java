package com.test.carCenter.models.service;

import com.test.carCenter.models.dao.IMecanicoDao;
import com.test.carCenter.models.entity.Mecanico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MecanicoServiceImpl implements  IMecanicoService
{
    @Autowired
    private IMecanicoDao mecanicoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Mecanico> findAll()
    {
        return (List<Mecanico>) mecanicoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Mecanico mecanico)
    {
        mecanicoDao.save(mecanico);
    }

    @Override
    @Transactional(readOnly = true)
    public Mecanico findOne(Long id)
    {
        return mecanicoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id)
    {
        mecanicoDao.deleteById(id);
    }
}
