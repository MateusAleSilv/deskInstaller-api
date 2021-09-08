package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class clienteController {
	
	public String nome = "";
	
	
	@GetMapping("/{get}")
	public String clientes() {
		if(nome.isEmpty()) {
			return "Não existe Clientes";
		} else {
			return nome;
		}
	}	
	
	@PostMapping("/{nome}")
	public String salvar(@PathVariable String nome){
	  this.nome = nome;
          return "Nome salvo com sucesso";
	}
	
	@PutMapping("/{put}")
	public String atualizar(@PathVariable String nNome) {
		this.salvar(nNome);
		return "Nome atualizado com sucesso";
	}
	
	@DeleteMapping("/{del}")
	public String deletar() {
		this.nome = "";
		return "";
	}
}
