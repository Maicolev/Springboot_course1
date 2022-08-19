create or replace NONEDITIONABLE PROCEDURE sp_calcular_prioridad_horas_trabajadas

--AUTHID CURRENT_USER
as
--variables 
out_resultado SYS_REFCURSOR;
begin 

open out_resultado for

    select mec_documento, sum(diferencia) as horas_trabajadas
    from(
        select mec_documento, 24 * (fecha_final - fecha_inicial) as diferencia
        from MANTENIMIENTOS)
    inner join mecanicos
    on mec_documento = documento
    where estado = 0
    group by mec_documento
    order by  horas_trabajadas
    fetch first 10 rows only;

dbms_sql.return_result(out_resultado);

end;