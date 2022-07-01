package com.squad_5.recursos.Recursos.Models;

public class HorasACargarDTO {
    public Integer horasTrabajadas;
    public Long cuit;
    public Long codigoTarea;
    public Long codigoProyecto;

    public HorasACargarDTO() {
    }

    public HorasACargarDTO(Integer horasTrabajadas, Long cuit, Long codigoTarea, Long codigoProyecto) {
        this.horasTrabajadas = horasTrabajadas;
        this.cuit = cuit;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
    }
}
