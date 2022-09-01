create or replace NONEDITIONABLE PROCEDURE sp_calcular_total_factura(p_codigo_factura number, p_codigo_mantenimiento number)

--AUTHID CURRENT_USER
as
--constantes
c_valor_max_repuestos facturas.precio_total%type;
c_porcentaje_descuento decimal;



--variables 
v_precio_subtotal facturas.precio_subtotal%type;
v_precio_total facturas.precio_total%type;
v_precio_mano_obra facturas.precio_total%type;


begin 
c_valor_max_repuestos := 3000000;
c_porcentaje_descuento := 0.50;


------ inicia calcular subtotal -------
    select sum(df.valor) into v_precio_subtotal
    from facturas fac
    inner join detalle_factura df
    on fac.codigo = df.mant_codigo 
    where fac.codigo = p_codigo_factura and df.mant_codigo = p_codigo_mantenimiento
    group by fac.codigo;

update facturas 
set precio_subtotal = v_precio_subtotal
where codigo = p_codigo_factura;
------ termina calcular subtotal -------



------ inicia calcular mano de obra -------

    select sum(serv.precio) into v_precio_mano_obra
    from mantenimientos mant
    inner join servicios_y_mantenimientos sym
    on mant.codigo = sym.cod_mantenimiento
    inner join servicios serv
    on sym.cod_servicio = serv.codigo
    where mant.codigo = p_codigo_mantenimiento
    group by sym.cod_mantenimiento;
------ termina calcular mano de obra -------



------ inicia calcular valor total -------
if v_precio_mano_obra > c_valor_max_repuestos then
    update facturas
    set precio_total = v_precio_subtotal - (v_precio_mano_obra*c_porcentaje_descuento),
    descuento =  (v_precio_mano_obra*c_porcentaje_descuento)
    where codigo = p_codigo_factura;
else
   update facturas 
    set precio_total = v_precio_total
    where codigo = p_codigo_factura;
end if;
----- termina calcular valor total -------

end;




