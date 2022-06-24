package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.HorasDia;
import com.squad_5.recursos.Recursos.Repositories.HorasDiaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class RecursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}

	@GetMapping(value = "/horasDia")
	public List<HorasDia> getHorasDia(HorasDiaRepository horasDiaRepository) {
		return horasDiaRepository.findAll();
	}

}
