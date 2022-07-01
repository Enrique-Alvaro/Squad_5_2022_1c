package com.squad_5.recursos.Recursos.Repositories;

import com.squad_5.recursos.Recursos.Models.Horas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HorasRepository extends JpaRepository<Horas, Long> {

    @Query(value = "select h from horas h where h.cuit=?1")
    public List<Horas> getHorasByCuit(Long cuit);

    //public List<Horas> getHorasByCuit(Long cuit);

}
