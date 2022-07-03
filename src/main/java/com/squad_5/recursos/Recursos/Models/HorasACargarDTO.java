package com.squad_5.recursos.Recursos.Models;

import java.time.LocalDate;

public class HorasACargarDTO {
    public Integer horasTrabajadas;
    public Long cuit;
    public Long codigoTarea;
    public Long codigoProyecto;
    public String detalle;
    public LocalDate fecha;
    public String nombre;

    public HorasACargarDTO() {
    }

    public HorasACargarDTO(Integer horasTrabajadas, Long cuit, Long codigoTarea, Long codigoProyecto, String detalle, LocalDate fecha, String nombre) {
        this.horasTrabajadas = horasTrabajadas;
        this.cuit = cuit;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
