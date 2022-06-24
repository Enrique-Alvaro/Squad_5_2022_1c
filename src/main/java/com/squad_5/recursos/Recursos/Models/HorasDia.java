package com.squad_5.recursos.Recursos.Models;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="HorasDia")
public class HorasDia {

    @Id
    @SequenceGenerator(
            name = "horas_dia_sequence",
            sequenceName = "horas_dia_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "horas_dia_sequence"
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

    public HorasDia() {

    }

    public HorasDia(int horasTrabajadas, Date fechaDia, Long CUIT) {
        this.horasTrabajadas = horasTrabajadas;
        this.fechaDia = fechaDia;
        this.CUIT = CUIT;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setFechaDia(Date fechaDia) {
        this.fechaDia = fechaDia;
    }

    public void setCUIT(Long CUIT) {
        this.CUIT = CUIT;
    }

    public Long getId() {
        return id;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public Date getFechaDia() {
        return fechaDia;
    }

    public Long getCUIT() {
        return CUIT;
    }
}
