package com.test.carCenter.models.entity;

public class MecanicosHorasTemp
{
    private long documento;

    private String horasTrabajadas;

    public MecanicosHorasTemp(long documento, String horasTrabajadas) {
        this.documento = documento;
        this.horasTrabajadas = horasTrabajadas;
    }
    public MecanicosHorasTemp(){};

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(String horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}
