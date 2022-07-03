package com.squad_5.recursos.Recursos.Services;
import com.squad_5.recursos.Recursos.Models.Empleado;
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
    @Autowired
    private EmpleadoService empleadoService;

    public List<Horas> getHoras() {
        return repository.findAll();
    }

    public Horas cargarHoras(HorasACargarDTO datos) {
        Horas nuevaHoras = new Horas(datos.legajo,
                                    datos.horasTrabajadas,
                                    datos.codigoTarea,
                                    datos.codigoProyecto,
                                    datos.detalle,
                                    datos.fecha,
                                    datos.nombre
        );
        return repository.save(nuevaHoras);
    }

    public List<Horas> getHorasByLegajo(int legajo) {
        Empleado[] empleados = empleadoService.getEmpleados();
        Boolean existe = false;
        Empleado empleado = null;

        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].legajo == legajo) {
                existe = true;
                empleado = empleados[i];
                break;
            }
        }

        if (existe) {
            List<Horas> coincidentes = repository.getHorasByCuit(legajo);
            for (Horas element : coincidentes) {
                element.setNombre(empleado.Nombre);
            }
            return coincidentes;
        }

        return null;

    }

    public void deleteHoras(int id) {
        repository.deleteById(id);
    }

    public Horas updateHoras(int id, Horas horas) {
        if (repository.findById(id).isPresent()) {
            horas.setId(id);
            return repository.save(horas);
        }
        return null;
    }

}