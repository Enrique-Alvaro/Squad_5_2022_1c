package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.HorasDia;
import com.squad_5.recursos.Recursos.Repositories.HorasDiaRepository;
import com.squad_5.recursos.Recursos.Services.HorasDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@SpringBootApplication
public class RecursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}


	@GetMapping(value="/recursos")
	@ResponseBody
	public String getRecursos() {
		final String uri = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}
	/*

	RUTAS QUE HAY QUE IMPLEMENTAR!!!!!

	@GetMapping(value="/horas/{id}")
	public List<Horas> getHorasConID(@PathVariable long id) {

	}

	@PostMapping(value="/horas")
	public Horas createHoras(@RequestBody Horas horas) {

	}

	@PostMapping(value="/horas{id}")
	public Horas updateHoras(@PathVariable long id, @RequestBody Horas horas) {

	}

	@DeleteMapping(value="/horas{id}")
	public void deleteHoras(@PathVariable long id) {

	}

	*/
}
