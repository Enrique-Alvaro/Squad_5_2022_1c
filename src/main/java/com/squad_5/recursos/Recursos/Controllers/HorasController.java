package com.squad_5.recursos.Recursos.Controllers;
import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Services.HorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/horas")
public class HorasController {
    private final HorasService horasService;

    @Autowired
    public HorasController(HorasService horasService) {
        this.horasService = horasService;
    }

    @GetMapping(value="{id}")
    public List<Horas> getHorasConID(@PathVariable("id") int legajo) {
        return horasService.getHorasByLegajo(legajo);
    }

    @PostMapping()
    public Horas createHoras(@RequestBody HorasACargarDTO horas) {
        return horasService.cargarHoras(horas);
    }

    @PutMapping(value="{id}")
    public Horas updateHoras(@PathVariable("id") int id, @RequestBody Horas horas) {
        return horasService.updateHoras(id, horas);
    }

    @DeleteMapping(value="{id}")
    public void deleteHoras(@PathVariable int id) {
        horasService.deleteHoras(id);
    }

}
