package com.test.carCenter.models.dao;

import com.test.carCenter.models.entity.Mecanico;
import org.springframework.data.repository.CrudRepository;

public interface IMecanicoDao extends CrudRepository<Mecanico, Long>
{
}
