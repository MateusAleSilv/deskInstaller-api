package br.com.ondatermica.ondatermica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class clienteController {
	
	public String nome = "Mateus";
	
	
	@GetMapping("/{get}")
	public String clientes() {
		if(nome == null) {
			return "Não existe Clientes";
		} else {
			return nome;
		}
	}	
	
	@PostMapping("/{post}")
	public String create(){
		if(nome == null) {
			String novoNome = null;
			nome = novoNome;
			novoNome = "Maria";
			return novoNome;
		} else {
			return "Nome Já criado";
		}
	}
	
	@PutMapping("/{put}")
	public String update() {
	   if(nome != null) {
		   String novoNome = null;
		   nome = novoNome;
		   novoNome = "João";
		   return novoNome;
	   } else {
		   return "Sem nome para alterar";
	   }
	}
	
	@DeleteMapping("/{del}")
	public void deletar() {
		return;
	}

}
