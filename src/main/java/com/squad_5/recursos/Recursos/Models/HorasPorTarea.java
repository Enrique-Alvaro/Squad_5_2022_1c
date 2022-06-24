package com.squad_5.recursos.Recursos.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="HorasPorTarea")
public class HorasPorTarea {

    @Id
    @Column(
            name = "codigo_tarea",
            nullable = false
    )
    Long codigoTarea;
    @Id
    @Column(
            name = "codigo_horas_dia",
            nullable = false
    )
    Long codigoHorasDia;

    public Long getCodigoTarea() {
        return codigoTarea;
    }

    public Long getCodigoHorasDia() {
        return codigoHorasDia;
    }

    public void setCodigoTarea(Long codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public void setCodigoHorasDia(Long codigoHorasDia) {
        this.codigoHorasDia = codigoHorasDia;
    }

    public HorasPorTarea(Long codigoTarea, Long codigoHorasDia) {
        this.codigoTarea = codigoTarea;
        this.codigoHorasDia = codigoHorasDia;
    }
}
