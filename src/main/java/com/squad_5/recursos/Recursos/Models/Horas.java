package com.squad_5.recursos.Recursos.Models;

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
    private Integer horasTrabajadas;

    @Column(
            name = "fecha_dia",
            nullable = false
    )
    private Date fechaDia;

    @Column(
            name = "cuit",
            nullable = false
    )
    private Long CUIT;

    @Column(
            name = "codigo_tarea",
            nullable = false
    )
    Long codigoTarea;

    @Column(
            name = "codigo_proyecto",
            nullable = false
    )
    Long codigoProyecto;

}
