package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ondatermica.ondatermica.model.cliente;

@RestController
@RequestMapping("/clientes")
public class clienteController {	
		
	
	private cliente cliente;
	
	
	@GetMapping
	public Object consultar() {
		if (this.cliente == null) {
			return "Não existe clientes";
		} else if(this.cliente != null) {
			return this.cliente;
		} 
		return "ERRO";
	}
	
	@PostMapping("/{nome}")
	public Object salvar(cliente nome){
	  this.cliente = nome;
          return "Nome inserido";
	}
	
	@PutMapping("/{nome}")
	public Object atualizar(cliente nome1){
		this.cliente.setNome(nome1);
		return "Nome Atualizado";
	}
	
	@DeleteMapping
	public Object deletar() {
		this.cliente = null;
		return "";
	}
	
	
	

}
