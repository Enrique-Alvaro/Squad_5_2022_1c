package com.squad_5.recursos.Recursos.Models;
import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="horas")
public class Horas {
    @Id
    @SequenceGenerator(
            name = "horas_sequence",
            sequenceName = "horas_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "horas_sequence"
    )
    public int id;
    @Column(
            name = "horas_trabajadas"
    )
    public int horasTrabajadas;
    public int legajo;
    @Column(
            name = "codigo_tarea"
    )
    public int codigoTarea;
    @Column(
            name = "codigo_proyecto"
    )
    public int codigoProyecto;

    public String detalle;
    public LocalDate fecha;
    public String nombre;

    public Horas() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horas(int legajo, int horasTrabajadas, int codigoTarea, int codigoProyecto, String detalle, LocalDate fecha, String nombre) {
        this.horasTrabajadas = horasTrabajadas;
        this.legajo = legajo;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
