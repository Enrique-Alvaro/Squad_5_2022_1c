package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Services.HorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@SpringBootApplication
public class RecursosApplication {

	@Autowired
	HorasService horasService;
	
	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}

	@GetMapping(value="/horas/{id}")
	public List<Horas> getHorasConID(@PathVariable long id) {
		return horasService.getHorasbyCuit(id);
	}

	@PostMapping(value="/horas")
	public Horas createHoras(@RequestBody HorasACargarDTO horas) {
		return horasService.cargarHoras(horas);
	}


	@PutMapping(value="/horas")
	public Horas updateHoras(@RequestBody Horas horas) {
		return horasService.updateHoras(horas);
	}

	@DeleteMapping(value="/horas/{id}")
	public void deleteHoras(@PathVariable long id) {
		horasService.deleteHoras(id);
	}
}
