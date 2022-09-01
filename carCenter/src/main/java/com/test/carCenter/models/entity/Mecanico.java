package com.test.carCenter.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MECANICOS")
public class Mecanico implements Serializable
{
    @Column(name = "tipo_documento")
    @Size(max = 2)
    @NotEmpty
    private String tipoDocumento;

    @Id
    @NotNull
    private Long documento;

    @Column(name = "primer_nombre")
    @Size(max = 30)
    @NotEmpty
    private String primerNombre;

    @Column(name = "segundo_nombre")
    @Size(max = 30)
    private String segundoNombre;

    @Column(name = "primer_apellido")
    @Size(max = 30)
    @NotEmpty
    private String primerApellido;

    @Column(name = "segundo_apellido")
    @Size(max = 30)
    private String segundoApellido;

    @Column
    @Size(max = 15)
    @NotEmpty
    private String celular;

    @Column
    @Size(max = 200)
    @NotEmpty
    private String direccion;

    @Column
    @Size(max = 100)
    @Email
    @NotEmpty
    private String email;

    @Column
    @Size(max = 1)
    @NotEmpty
    private String estado;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
