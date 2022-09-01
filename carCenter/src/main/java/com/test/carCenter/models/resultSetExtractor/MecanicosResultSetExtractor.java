package com.test.carCenter.models.resultSetExtractor;

import com.test.carCenter.models.entity.MecanicosHorasTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MecanicosResultSetExtractor implements ResultSetExtractor, IMecanicoResultSetExtractor
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MecanicosHorasTemp> extractData(ResultSet rs) throws SQLException, DataAccessException
    {
        List<MecanicosHorasTemp> list=new ArrayList<>();
        while(rs.next()){
            MecanicosHorasTemp mecanicohoras=new MecanicosHorasTemp();
            mecanicohoras.setDocumento(rs.getLong(1));
            mecanicohoras.setHorasTrabajadas(rs.getString(2));
            list.add(mecanicohoras);
        }
        return list;
    }

    public List<MecanicosHorasTemp> darMecanicosPorPrioridades()
    {
        //return (Map<MecanicosHorasTemp>) jdbcTemplate.queryForMap("call sp_calcular_prioridad_horas_trabajadas", new MecanicosResultSetExtractor());
        return (List<MecanicosHorasTemp>) jdbcTemplate.query("select mec_documento, sum(diferencia) as horas_trabajadas  from( select mec_documento, 24 * (fecha_final - fecha_inicial) as diferencia from MANTENIMIENTOS)  inner join mecanicos  on mec_documento = documento  where estado = 0  group by mec_documento  order by  horas_trabajadas  fetch first 10 rows only",new MecanicosResultSetExtractor());
    }

    @Override
    public void spEliminarMecanico(long documento)
    {
        jdbcTemplate.update("call SP_ELIMINAR_MECANICO (?)", documento);
    }

    @Override
    public void spCrearEditarMecanico(String tipoDocumento, long documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String celular, String direccion, String email, String estado)
    {
        jdbcTemplate.update("call sp_crear_editar_mecanico (?,?,?,?,?,?,?,?,?,?)", tipoDocumento,documento,primerNombre,segundoNombre,primerApellido,segundoApellido,celular,direccion,email,estado);
    }
}
