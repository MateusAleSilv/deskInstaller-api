package br.com.ondatermica.ondatermica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ondatermica.ondatermica.model.Itens;
import br.com.ondatermica.ondatermica.repository.ItensRepository;

@RestController
@RequestMapping("/itens")
public class ItensController {

	@Autowired
	private ItensRepository itensRepository;
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Itens>> consultar(@PathVariable("id") int id){
		return ResponseEntity.ok(itensRepository.findById(id));		
	}
	
	@GetMapping("/numero/{numero}")
	public ResponseEntity<Optional<List<Itens>>> numeroItem(@PathVariable("numero") int itemnumero){
		return ResponseEntity.ok(itensRepository.findByItemnumeroContainingOrderByItemnumero(itemnumero));
	}
	
	
	// --------------------------------------------------------------------------------------------------------
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Itens salvar(@Validated @RequestBody Itens itens) {
		return itensRepository.save(itens);
	}	
}
