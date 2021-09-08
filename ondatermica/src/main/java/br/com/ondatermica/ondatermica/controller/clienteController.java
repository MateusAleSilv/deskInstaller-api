package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ondatermica.ondatermica.model.*;

@RestController
@RequestMapping("/clientes")
public class clienteController extends cliente {	
		
	//Não consegui fazer rodar, fica dando erro quando chama o metodo
	
	
		@GetMapping
		public Object consultar() {
			setNome(null);
			if(this.getNome() == null) {
				return this.getNome();
			} else {
				return "BlaBla";
			}
		}	
		
		@PostMapping("/{nome}")
		public Object salvar(@PathVariable String nome){
	        this.setNome(null);
			if(this.getNome() == null) {
	        	this.setNome(nome);
	        } 
			return nome;
	   }
	        
		
		@PutMapping("/{nome}")
		public Object atualizar(@PathVariable String nNome) {
			this.setNome(null);
			if(this.getNome() == null) {
				return "Não há nomes para alterar";
			} 
			return nNome;
		}
		
		@DeleteMapping
		public Object deletar() {
			this.setNome(null);
			return "";
		}

	

}
