package com.squad_5.recursos.Recursos.Controllers;
import com.squad_5.recursos.Recursos.Models.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "api/empleados")
public class EmpleadoController {
    @GetMapping
    public Empleado[] getStudents() {
        final String uri = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Empleado[]> response = restTemplate.getForEntity(uri, Empleado[].class);
        Empleado[] empleados = response.getBody();
        return empleados;
    }

    @GetMapping(path = "{empleadoId}")
    public Empleado getStudent(@PathVariable("empleadoId") int empleadoId) {
        final String uri = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Empleado[]> response = restTemplate.getForEntity(uri, Empleado[].class);
        Empleado[] empleados = response.getBody();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].legajo == empleadoId) return empleados[i];
        }
        return null;
    }

}
