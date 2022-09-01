package com.test.carCenter.models.service;

import com.test.carCenter.models.entity.Mecanico;

import java.util.List;

public interface IMecanicoService
{
    public List<Mecanico> findAll();

    public void save (Mecanico mecanico);

    public Mecanico findOne(Long id);

    public void delete(Long id);
}
