package com.squad_5.recursos.Recursos.Repositories;

import com.squad_5.recursos.Recursos.Models.HorasDia;
import com.squad_5.recursos.Recursos.Models.HorasPorTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorasPorTareaRepository extends JpaRepository<HorasPorTarea, Long> {
}
