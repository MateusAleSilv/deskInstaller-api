package br.com.ondatermica.ondatermica.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")

public class health {

	@GetMapping("/{tipo}") 
	public String GetHealth(@PathVariable Integer tipo) {
		LocalDateTime localDateTime = LocalDateTime.now();
		if (tipo == 0) {
			return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy*-"));
		} else if(tipo == 1) {
			return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		}
		return "ERRO DE PARAMETROS";
	}
	
	
}
