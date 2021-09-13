package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import br.com.ondatermica.ondatermica.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {	
		
	
	private Cliente cliente;
	
	
	@GetMapping
	public Object consultar() {
		if(this.cliente != null) {
			return this.cliente;
		} else if (this.cliente == null){
			return "Está vazio";
		} 
		return "ERRO";
	}
	
	@GetMapping("/{email}")
	public Object email() {
		if(this.cliente != null) {
			this.cliente.getEmail();
			return this.cliente.getEmail();
		}
		return "Está Vazio";
	}
	
	@GetMapping("/2/{cpf}")
	public Object cpf() {
		if(this.cliente != null) {
			return this.cliente.getCpf();
		}
		return "Erro";
	}
	
	@PostMapping
	public Object salvar(@RequestBody Cliente cliente){
		this.cliente = cliente;
          return "Dados inseridos";
	}
	
	@PutMapping
	public Object atualizar(@RequestBody Cliente cliente){
		this.salvar(cliente);
		return "Dados atualizados";
	}
	
	@DeleteMapping
	public Object deletar() {
		this.cliente = null;
		return "";
	}
	
	
	

}
