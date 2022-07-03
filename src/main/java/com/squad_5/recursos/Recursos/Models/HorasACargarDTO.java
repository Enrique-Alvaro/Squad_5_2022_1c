package com.squad_5.recursos.Recursos.Models;

import java.time.LocalDate;

public class HorasACargarDTO {
    public int horasTrabajadas;
    public int legajo;
    public int codigoTarea;
    public int codigoProyecto;
    public String detalle;
    public LocalDate fecha;
    public String nombre;

    public HorasACargarDTO() {
    }

    public HorasACargarDTO(int horasTrabajadas, int legajo, int codigoTarea, int codigoProyecto, String detalle, LocalDate fecha, String nombre) {
        this.horasTrabajadas = horasTrabajadas;
        this.legajo = legajo;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
