--Full optimized

-- -----------------------------------------------------
-- Table REPUESTOS
-- -----------------------------------------------------
CREATE TABLE REPUESTOS (
  codigo INTEGER NOT NULL,
  nombre_respuesto VARCHAR2(100) NOT NULL,
  precio_unitario DECIMAL NOT NULL,
  unidades_inventario INTEGER NOT NULL,
  proveedor VARCHAR2(200) NOT NULL,
  PRIMARY KEY (codigo))
;

-- -----------------------------------------------------
-- Table MECANICOS
-- -----------------------------------------------------
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
;

-- -----------------------------------------------------
-- Table MARCAS
-- -----------------------------------------------------
CREATE TABLE MARCAS (
  codigo INTEGER NOT NULL,
  nombre_marca VARCHAR2(30) NOT NULL,
  PRIMARY KEY (codigo))
;

-- -----------------------------------------------------
-- Table CLIENTES
-- -----------------------------------------------------
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
;

-- -----------------------------------------------------
-- Table VEHICULOS
-- -----------------------------------------------------
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
    ;

-- -----------------------------------------------------
-- Table MANTENIMIENTOS
-- -----------------------------------------------------
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
    ;

-- -----------------------------------------------------
-- Table REPUESTOS_Y_MANTENIMIENTOS
-- -----------------------------------------------------
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
    ;

-- -----------------------------------------------------
-- Table SERVICIOS
-- -----------------------------------------------------
CREATE TABLE SERVICIOS (
  codigo INTEGER NOT NULL,
  nombre_servicio VARCHAR2(100) NOT NULL,
  precio DECIMAL NOT NULL,
  precio_min DECIMAL NOT NULL,
  precio_max DECIMAL NOT NULL,
  PRIMARY KEY (codigo))
;

-- -----------------------------------------------------
-- Table SERVICIOS_Y_MANTENIMIENTOS
-- -----------------------------------------------------
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
    ;

-- -----------------------------------------------------
-- Table FOTOS
-- -----------------------------------------------------
CREATE TABLE FOTOS (
  codigo INTEGER NOT NULL,
  ruta VARCHAR2(200) NULL,
  cod_mantenimiento INTEGER NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_FOTOS_MANTENIMIENTOS1
    FOREIGN KEY (cod_mantenimiento)
    REFERENCES MANTENIMIENTOS (codigo))
    ;

-- -----------------------------------------------------
-- Table FACTURAS
-- -----------------------------------------------------
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
    ;

-- -----------------------------------------------------
-- Table DETALLE_FACTURA_MANTENIMIENTOS
-- -----------------------------------------------------
CREATE TABLE DETALLE_FACTURA_MANTENIMIENTOS (
  codigo INTEGER NOT NULL,
  mant_codigo INTEGER NOT NULL,
  mec_tipo_documento VARCHAR2(2) NOT NULL,
  mec_documento INTEGER NOT NULL,
  vehi_placa VARCHAR2(9) NOT NULL,
  fact_codigo INTEGER NOT NULL,
  precio_unitario DECIMAL NOT NULL,
  valor DECIMAL NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_MANTENIMIENTOS_has_FACTURA_MANTENIMIENTOS1
    FOREIGN KEY (mant_codigo)
    REFERENCES MANTENIMIENTOS (codigo),
  CONSTRAINT fk_MANTENIMIENTOS_has_FACTURA_FACTURA1
    FOREIGN KEY (fact_codigo)
    REFERENCES FACTURAS (codigo))
    ;

DROP TABLE REPUESTOS_Y_MANTENIMIENTOS;
DROP TABLE SERVICIOS_Y_MANTENIMIENTOS;
DROP TABLE FOTOS;
DROP TABLE DETALLE_FACTURA_MANTENIMIENTOS;
DROP TABLE MANTENIMIENTOS;
DROP TABLE REPUESTOS;
DROP TABLE VEHICULOS;
DROP TABLE SERVICIOS;
DROP TABLE MECANICOS;
DROP TABLE MARCAS;
DROP TABLE FACTURAS;
DROP TABLE CLIENTES;
