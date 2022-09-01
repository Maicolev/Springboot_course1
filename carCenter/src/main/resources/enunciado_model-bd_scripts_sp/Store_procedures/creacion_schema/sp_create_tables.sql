create or replace NONEDITIONABLE PROCEDURE sp_create_tables

AUTHID CURRENT_USER
as
--variables 
    repuestos_table VARCHAR2(10000);
    mecanicos_table VARCHAR2(10000);
    marcas_table VARCHAR2(10000);
    clientes_table VARCHAR2(10000);
    vehiculos_table VARCHAR2(10000);
    mantenimientos_table VARCHAR2(10000);
    repuestos_y_mantenimientos_table VARCHAR2(10000);
    servicios_table VARCHAR2(10000);
    servicios_mantenimientos_table VARCHAR2(10000);
    fotos_table VARCHAR2(10000);
    facturas_table VARCHAR2(10000);
    detalle_factura_table VARCHAR2(10000);


    begin
    repuestos_table := '
        CREATE TABLE REPUESTOS (
      codigo INTEGER NOT NULL,
      nombre_respuesto VARCHAR2(100) NOT NULL,
      precio_unitario DECIMAL NOT NULL,
      unidades_inventario INTEGER NOT NULL,
      proveedor VARCHAR2(200) NOT NULL,
      PRIMARY KEY (codigo))
    ';

    mecanicos_table := '
        CREATE TABLE MECANICOS (
      tipo_documento VARCHAR2(2) NOT NULL,
      documento INTEGER NOT NULL,
      primer_nombre VARCHAR2(30) NOT NULL,
      segundo_nombre VARCHAR2(30) NULL,
      primer_apellido VARCHAR2(30) NOT NULL,
      segundo_apellido VARCHAR2(30) NULL,
      celular VARCHAR2(15) NOT NULL,
      direccion VARCHAR2(200) NOT NULL,
      email VARCHAR2(100) NOT NULL,
      estado CHAR(1) NOT NULL,
      PRIMARY KEY (tipo_documento, documento))
  ';

    marcas_table := '
        CREATE TABLE MARCAS (
      codigo INTEGER NOT NULL,
      nombre_marca VARCHAR2(30) NOT NULL,
      PRIMARY KEY (codigo))
  ';

    clientes_table := '
        CREATE TABLE CLIENTES (
      tipo_documento VARCHAR2(2) NOT NULL,
      documento INTEGER NOT NULL,
      primer_nombre VARCHAR2(30) NOT NULL,
      segundo_nombre VARCHAR2(30) NULL,
      primer_apellido VARCHAR2(30) NOT NULL,
      segundo_apellido VARCHAR2(30) NULL,
      celular VARCHAR2(15) NOT NULL,
      direccion VARCHAR2(200) NOT NULL,
      email VARCHAR2(100) NOT NULL,
      PRIMARY KEY (tipo_documento, documento))
  ';

    vehiculos_table := '
        CREATE TABLE VEHICULOS (
      placa VARCHAR2(9) NOT NULL,
      color VARCHAR2(30) NOT NULL,
      cod_marca INTEGER NOT NULL,
      cli_tipo_documento VARCHAR2(2) NOT NULL,
      cli_documento INTEGER NOT NULL,
      PRIMARY KEY (placa),
      CONSTRAINT fk_VEHICULOS_MARCAS1
        FOREIGN KEY (cod_marca)
        REFERENCES MARCAS (codigo),
      CONSTRAINT fk_VEHICULOS_CLIENTES1
        FOREIGN KEY (cli_tipo_documento , cli_documento)
        REFERENCES CLIENTES (tipo_documento , documento))
    ';

    mantenimientos_table := '
        CREATE TABLE MANTENIMIENTOS (
      codigo INTEGER NOT NULL,
      estado INTEGER NULL,
      fecha_inicial DATE NOT NULL,
      fecha_final DATE NULL,
      mec_tipo_documento VARCHAR2(2) NOT NULL,
      mec_documento INTEGER NOT NULL,
      vehi_placa VARCHAR2(9) NOT NULL,
      PRIMARY KEY (codigo),
      CONSTRAINT fk_MANTENIMIENTOS_MECANICOS1
        FOREIGN KEY (mec_tipo_documento , mec_documento)
        REFERENCES MECANICOS (tipo_documento , documento),
      CONSTRAINT fk_MANTENIMIENTOS_VEHICULOS1
        FOREIGN KEY (vehi_placa)
        REFERENCES VEHICULOS (placa))
    ';

    repuestos_y_mantenimientos_table := '
        CREATE TABLE REPUESTOS_Y_MANTENIMIENTOS (
      codigo INTEGER NOT NULL,
      unidades INTEGER NOT NULL,
      tiempo_estimado INTEGER NOT NULL,
      cod_mantenimientos INTEGER NOT NULL,
      cod_repuesto INTEGER NOT NULL,
      precio_mano_obra DECIMAL NOT NULL,
      PRIMARY KEY (codigo),
      CONSTRAINT fk_REPUESTOS_Y_MANTENIMIENTOS_REPUESTOS
        FOREIGN KEY (cod_repuesto)
        REFERENCES REPUESTOS (codigo),
      CONSTRAINT fk_REPUESTOS_Y_MANTENIMIENTOS_MANTENIMIENTOS1
        FOREIGN KEY (cod_mantenimientos)
        REFERENCES MANTENIMIENTOS (codigo))
    ';

    servicios_table := '
        CREATE TABLE SERVICIOS (
      codigo INTEGER NOT NULL,
      nombre_servicio VARCHAR2(100) NOT NULL,
      precio DECIMAL NOT NULL,
      precio_min DECIMAL NOT NULL,
      precio_max DECIMAL NOT NULL,
      PRIMARY KEY (codigo))
  ';

    servicios_mantenimientos_table := '
        CREATE TABLE SERVICIOS_Y_MANTENIMIENTOS (
      codigo INTEGER NOT NULL,
      tiempo_estimado INTEGER NOT NULL,
      cod_mantenimiento INTEGER NOT NULL,
      cod_servicio INTEGER NOT NULL,
      PRIMARY KEY (codigo),
      CONSTRAINT fk_SERVICIOS_Y_MANTENIMIENTOS_MANTENIMIENTOS1
        FOREIGN KEY (cod_mantenimiento)
        REFERENCES MANTENIMIENTOS (codigo),
      CONSTRAINT fk_SERVICIOS_Y_MANTENIMIENTOS_SERVICIOS1
        FOREIGN KEY (cod_servicio)
        REFERENCES SERVICIOS (codigo))
    ';

    fotos_table := '
        CREATE TABLE FOTOS (
      codigo INTEGER NOT NULL,
      ruta VARCHAR2(200) NULL,
      cod_mantenimiento INTEGER NOT NULL,
      PRIMARY KEY (codigo),
      CONSTRAINT fk_FOTOS_MANTENIMIENTOS1
        FOREIGN KEY (cod_mantenimiento)
        REFERENCES MANTENIMIENTOS (codigo))
    ';

    facturas_table := '
CREATE TABLE FACTURAS (
  codigo INTEGER NOT NULL,
  fecha DATE NOT NULL,
  iva DECIMAL NULL,
  precio_total DECIMAL NOT NULL,
  cli_tipo_documento VARCHAR2(2) NOT NULL,
  cli_documento INTEGER NOT NULL,
  descuento DECIMAL NULL,
  precio_subtotal DECIMAL NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_FACTURA_CLIENTES1
    FOREIGN KEY (cli_tipo_documento , cli_documento)
    REFERENCES CLIENTES (tipo_documento , documento))
    ';

    detalle_factura_table := '
        CREATE TABLE DETALLE_FACTURA (
      codigo INTEGER NOT NULL,
      mant_codigo INTEGER NOT NULL,
      mec_tipo_documento VARCHAR2(2) NOT NULL,
      mec_documento INTEGER NOT NULL,
      vehi_placa VARCHAR2(9) NOT NULL,
      fact_codigo INTEGER NOT NULL,
      precio_unitario integer not null,
      valor integer not null,
      PRIMARY KEY (codigo),
      CONSTRAINT fk_MANTENIMIENTOS_has_FACTURA_MANTENIMIENTOS1
        FOREIGN KEY (mant_codigo)
        REFERENCES MANTENIMIENTOS (codigo),
      CONSTRAINT fk_MANTENIMIENTOS_has_FACTURA_FACTURA1
        FOREIGN KEY (fact_codigo)
        REFERENCES FACTURAS (codigo))
    ';



      execute immediate repuestos_table;
      execute immediate mecanicos_table;
      execute immediate marcas_table;
      execute immediate clientes_table;
      execute immediate vehiculos_table;
      execute immediate mantenimientos_table;
      execute immediate repuestos_y_mantenimientos_table;
      execute immediate servicios_table;
      execute immediate servicios_mantenimientos_table;
      execute immediate fotos_table;
      execute immediate facturas_table;
      execute immediate detalle_factura_table;
end;