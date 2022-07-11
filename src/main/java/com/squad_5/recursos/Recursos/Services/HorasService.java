package com.squad_5.recursos.Recursos.Services;
import com.squad_5.recursos.Recursos.Models.Empleado;
import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Repositories.HorasRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        if(datos.horasTrabajadas > 24){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las horas trabajadas son invalidas");
        }

        final String uri = "https://moduloproyectos.herokuapp.com/proyectos/"+datos.codigoProyecto+"/tareas/"+datos.codigoTarea+"/empleados/"+datos.legajo+"/exist";
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject(uri, Boolean.class);

        Boolean valido = false;
        Empleado[] empleados = empleadoService.getEmpleados();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].legajo == datos.legajo) {
                valido = true;
                break;
            }
        }

        if(!valido) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe este empleado");
        }

        if (result){
            Horas nuevaHoras = new Horas(datos.legajo,
                    datos.horasTrabajadas,
                    datos.codigoTarea,
                    datos.codigoProyecto,
                    datos.detalle,
                    datos.fecha,
                    datos.nombre
            );
            return repository.save(nuevaHoras);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe esta relacion");
        }
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
        if (!repository.findById(id).isPresent()) {
            return null;
        }

        Horas unRegistro = repository.findById(id).orElseThrow(()-> new IllegalStateException("Student with id " + id + " does not exist."));

        if(horas.horasTrabajadas != 0){
            unRegistro.horasTrabajadas = horas.horasTrabajadas;
        }
        if(horas.legajo != 0){
            unRegistro.legajo = horas.legajo;
        }
        if(horas.codigoTarea != 0){
            unRegistro.codigoTarea = horas.codigoTarea;
        }
        if(horas.codigoProyecto != 0){
            unRegistro.codigoProyecto = horas.codigoProyecto;
        }
        if(horas.detalle != null){
            unRegistro.detalle = horas.detalle;
        }
        if(horas.fecha != null){
            unRegistro.fecha = horas.fecha;
        }
        if(horas.nombre != null){
            unRegistro.nombre = horas.nombre;
        }

        return repository.save(unRegistro);

    }

}