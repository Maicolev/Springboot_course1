package com.test.carCenter.models.resultSetExtractor;

import com.test.carCenter.models.entity.MecanicosHorasTemp;

import java.util.List;

public interface IMecanicoResultSetExtractor
{
    public List<MecanicosHorasTemp> darMecanicosPorPrioridades();

    public void spEliminarMecanico(long documento);

    public void spCrearEditarMecanico(String tipoDocumento, long documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String celular, String direccion, String email, String estado);
}
