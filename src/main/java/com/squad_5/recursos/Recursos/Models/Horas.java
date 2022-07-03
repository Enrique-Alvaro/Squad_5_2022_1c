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
    public Long id;
    @Column(
            name = "horas_trabajadas"
    )
    public Integer horasTrabajadas;
    public Long cuit;
    @Column(
            name = "codigo_tarea"
    )
    public Long codigoTarea;
    @Column(
            name = "codigo_proyecto"
    )
    public Long codigoProyecto;

    public String detalle;
    public LocalDate fecha;
    public String nombre;

    public Horas() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horas(Long cuit, Integer horasTrabajadas, Long codigoTarea, Long codigoProyecto, String detalle, LocalDate fecha, String nombre) {
        this.horasTrabajadas = horasTrabajadas;
        this.cuit = cuit;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
