package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cliente")
public class clienteController {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	@GetMapping("/{consultar}")
	public String GetCliente() {
		nome = "Jão";
		return nome;
		
	}
	
	@PostMapping("/{criar}")
	public String cadastrar(){
		 
		return "Usuário criado com sucesso";
		
	}

	@DeleteMapping("/{deletar}")
	public String deletar() {
		return " ";
	}
}
