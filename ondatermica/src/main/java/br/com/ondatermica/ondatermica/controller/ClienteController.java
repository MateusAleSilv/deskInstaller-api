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

import br.com.ondatermica.ondatermica.model.Cliente;
import br.com.ondatermica.ondatermica.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes") 
public class ClienteController {	
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	// --------------------------------------------------------------------------------------------
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Cliente>> consultar(@PathVariable("id") int id) { 
		return ResponseEntity.ok(clienteRepository.findById(id));
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Optional<List<Cliente>>> cpf(@PathVariable("cpf") String cpf) { 
		if(cpf.equalsIgnoreCase("@")) {
			cpf = "";
		}
		 return ResponseEntity.ok(clienteRepository.findByCpfContainingOrderByCpf(cpf));	
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Optional<List<Cliente>>> email(@PathVariable("email") String email) { 
		if (email.equalsIgnoreCase("@")) {
			email = "";
		}
		 return ResponseEntity.ok(clienteRepository.findByEmailContainingOrderByEmail(email));	
	}
	
	// -------------------------------------------------------------------------------------------
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@Validated @RequestBody Cliente cliente){ 
		return clienteRepository.save(cliente);
	}
	

	
	
	
}
