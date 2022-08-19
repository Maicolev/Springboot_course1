create or replace NONEDITIONABLE PROCEDURE SP_ELIMINAR_MECANICO (
p_documento_mecanico number
)AS 
BEGIN
 delete from mecanicos 
 where documento = p_documento_mecanico;
 commit;
END SP_ELIMINAR_MECANICO;