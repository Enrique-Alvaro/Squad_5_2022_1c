package com.squad_5.recursos.Recursos.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

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
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "horas_trabajadas",
            nullable = false
    )
    public Integer horasTrabajadas;

    @Column(
            name = "cuit",
            nullable = false
    )
    public Long cuit;

    @Column(
            name = "codigo_tarea",
            nullable = false
    )
    public Long codigoTarea;

    @Column(
            name = "codigo_proyecto",
            nullable = false
    )
    public Long codigoProyecto;

    public Horas() {
    }

    public Long getId() {
        return this.id;
    }

    public Horas(Long cuit, Integer horasTrabajadas, Long codigoTarea, Long codigoProyecto) {
        this.cuit = cuit;
        this.horasTrabajadas = horasTrabajadas;
        this.codigoTarea = codigoTarea;
        this.codigoProyecto = codigoProyecto;
    }
}
