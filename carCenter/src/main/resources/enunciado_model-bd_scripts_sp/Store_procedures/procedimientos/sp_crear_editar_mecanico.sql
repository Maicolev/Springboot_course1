create or replace NONEDITIONABLE PROCEDURE sp_crear_editar_mecanico (
p_tipo_documento varchar2,
p_documento number,
p_primer_nombre varchar2,
p_segundo_nombre varchar2,
p_primer_apellido varchar2,
p_segundo_apellido varchar2,
p_celular varchar2,
p_direccion varchar2,
p_email varchar2,
p_estado CHAR

)

--AUTHID CURRENT_USER
as
--variables 
v_resultado mecanicos.documento%type;
begin 


select documento into v_resultado
from mecanicos
where documento = p_documento;

       UPDATE mecanicos
        SET TIPO_DOCUMENTO = p_tipo_documento,
        DOCUMENTO = p_documento, 
        PRIMER_NOMBRE = p_primer_nombre, 
        SEGUNDO_NOMBRE = p_segundo_nombre, 
        PRIMER_APELLIDO = p_primer_apellido, 
        SEGUNDO_APELLIDO = p_segundo_apellido, 
        CELULAR = p_celular, 
        DIRECCION = p_direccion, 
        EMAIL = p_email, 
        ESTADO = p_estado
        WHERE documento = p_documento;

    exception
        when no_data_found then
        insert into MECANICOS (TIPO_DOCUMENTO, DOCUMENTO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CELULAR, DIRECCION, EMAIL, ESTADO) 
                values (p_tipo_documento, p_documento, p_primer_nombre, p_segundo_nombre, p_primer_apellido, p_segundo_apellido, p_celular, p_direccion, p_email, p_estado) ;
                commit;

end;