package com.squad_5.recursos.Recursos.Services;

import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Repositories.HorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorasService {

    @Autowired
    private HorasRepository repository;

    public List<Horas> getHoras() {
        return repository.findAll();
    }

    public Horas cargarHoras(HorasACargarDTO datos) {
        Horas nuevaHoras = new Horas(datos.cuit,
                                    datos.horasTrabajadas,
                                    datos.codigoTarea,
                                    datos.codigoProyecto
        );
        return repository.save(nuevaHoras);
    }


    public List<Horas> getHorasbyCuit(Long cuit) {
        return repository.getHorasByCuit(cuit);
    }

    public void deleteHoras(Long id) {
        repository.deleteById(id);
    }

    public Horas updateHoras(Horas horas) {
        if (repository.findById(horas.getId()).isPresent()) {
            return repository.save(horas);
        }
        return null;
    }

}