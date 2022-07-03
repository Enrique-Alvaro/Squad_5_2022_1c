package com.squad_5.recursos.Recursos.Controllers;
import com.squad_5.recursos.Recursos.Models.Empleado;
import com.squad_5.recursos.Recursos.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public Empleado[] getEmpleados() {
        return empleadoService.getEmpleados();
    }

    @GetMapping(path = "{empleadoId}")
    public Empleado getEmpleado(@PathVariable("empleadoId") int empleadoId) {
        Empleado[] empleados = empleadoService.getEmpleados();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].legajo == empleadoId) return empleados[i];
        }
        return null;
    }

}
