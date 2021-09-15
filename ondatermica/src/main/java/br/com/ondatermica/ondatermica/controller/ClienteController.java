package br.com.ondatermica.ondatermica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import br.com.ondatermica.ondatermica.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {	
		
	private Cliente cliente;
	private List<Cliente> listaCliente;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> consultar() {
		if(this.listaCliente != null) {
			return ResponseEntity.ok(listaCliente);
		} 
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Cliente> email(@PathVariable("email") String email) {
		if(this.listaCliente != null) {
			for (int i=0;i<listaCliente.size();i++) {
				if(this.listaCliente.get(i).getEmail().equalsIgnoreCase(email)) {
					return ResponseEntity.ok(this.listaCliente.get(i));
				}
			}
		} 
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> cpf(@PathVariable("cpf") String cpf) {
		if(this.listaCliente != null) {
			for (int i=0;i<listaCliente.size();i++) {
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cpf)) {
					return ResponseEntity.ok(this.listaCliente.get(i));
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente){
		if(this.listaCliente == null) {
			this.listaCliente = new ArrayList<Cliente>();
		}
		this.listaCliente.add(cliente);
		return ResponseEntity.ok("Dados Inseridos");
		
	}
	
	@PutMapping
	public ResponseEntity<String> atualizar(@RequestBody Cliente cliente){
		if(this.listaCliente != null) {
			for (int i=0;i<listaCliente.size();i++) {
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cliente.getCpf())) {
					this.listaCliente.get(i).setNome(cliente.getNome());
					this.listaCliente.get(i).setDataNasc(cliente.getDataNasc());
					this.listaCliente.get(i).setRg(cliente.getRg());
					this.listaCliente.get(i).setEmail(cliente.getEmail());
					this.listaCliente.get(i).setTelefone(cliente.getTelefone());
					this.listaCliente.get(i).setSalario(cliente.getSalario());
					return ResponseEntity.ok("Dados Atualizados");
				}	
			}
		}	
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deletar(@PathVariable("cpf") String cpf) {
		if(this.listaCliente != null) {
			for(int i=0;i<listaCliente.size();i++) {
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cpf)) {
					this.listaCliente.remove(i);
					return ResponseEntity.ok("Cliente removido");
				}
			}
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	

}
