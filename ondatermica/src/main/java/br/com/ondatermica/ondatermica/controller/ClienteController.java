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

@RestController // Avisa que a nossa classe controller é um REST.
@RequestMapping("/clientes") // Para implementar uma url, e usar os metodos GET, POST, PUT, DELETE
public class ClienteController {	// Diz que nossa classe é publico e o nome da classe.
		
	private List<Cliente> listaCliente; // Cliente se torna uma lista e é chamado de listaCliente.
	
	
	@GetMapping // Faz uma consulta. É um atalho do @RequestMapping.
	public ResponseEntity<List<Cliente>> consultar() { // Declara o metodo publico, Usa como resposta uma lista.
		if(this.listaCliente != null) { // Verifica se a lista não é nula
			return ResponseEntity.ok(listaCliente); // Retorna um recurso 200 e a listaCliente.
		} 
		return ResponseEntity.notFound().build(); // Retorna um recurso não encontrado, deixando a página em branco, e não aparecendo um erro.
	}
	
	@GetMapping("/email/{email}") // Faz uma consulta especifica.
	public ResponseEntity<Cliente> email(@PathVariable("email") String email) { // Declara o metodo como publico. Usa como resposta Cliente e mapeia o EMAIl no parametro.
		if(this.listaCliente != null) { // Verifica se a lista não é nula.
			for (int i=0;i<listaCliente.size();i++) { // Percorre o ' i ' para fazer uma listagem e mapeamento.
				if(this.listaCliente.get(i).getEmail().equalsIgnoreCase(email)) { // Verifica se a listaCliente tem o EMAIL que vai ser passado.
					return ResponseEntity.ok(this.listaCliente.get(i)); // Retorna como resposta a listaCliente que foi inserido no EMAIL.
				}
			}
		} 
		return ResponseEntity.notFound().build(); // Retorna um recurso não encontrado, deixando a página em branco, e não aparecendo um erro.
	}
	
	@GetMapping("/cpf/{cpf}") // Faz uma consulta especifica.
	public ResponseEntity<Cliente> cpf(@PathVariable("cpf") String cpf) { // Declara o metodo como publico, Usa uma resposta Cliente e mapeia o CPF no parametro.
		if(this.listaCliente != null) { // Verifica se a listaCliente não é nula.
			for (int i=0;i<listaCliente.size();i++) { //  Percorre o ' i ' para fazer uma listagem e mapeamento.
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cpf)) { // Verifica se a listaCliente tem o "CPF" que vai ser passado.
					return ResponseEntity.ok(this.listaCliente.get(i)); // Retorna como resposta a listaCliente que foi inserida no CPF.
				}
			}
		}
		return ResponseEntity.notFound().build(); // Retorna um recurso não encontrado, deixando a página em branco, e não aparecendo um erro.
	}
	
	@PostMapping // Inseri dados. É atalho do @RequestMapping
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente){ // Declara o metodo como publico, Usa uma resposta String e indica o parametro Cliente como cliente.
		if(this.listaCliente == null) { // Verifica se a listaCliente é nula.
			this.listaCliente = new ArrayList<Cliente>(); // Instancia a listaCliente.
		}
		this.listaCliente.add(cliente); // Adiciona dados do cliente a listaCliente.
		return ResponseEntity.ok("Dados Inseridos"); // Retorna um recurso 200 com a frase escrita.
		
	}
	
	@PutMapping // Atualiza os dados inseridos. É atalho do @RequestMapping
	public ResponseEntity<String> atualizar(@RequestBody Cliente cliente){ // Declara o metodo como publico, Usa uma resposta String e indica o parametro Cliente como cliente.
		if(this.listaCliente != null) { // Verifica se a lista não é nula.
			for (int i=0;i<listaCliente.size();i++) { // // Percorre o ' i ' para fazer uma listagem e mapeamento.
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cliente.getCpf())) { //
					this.listaCliente.get(i).setNome(cliente.getNome()); // Percorre a lista para achar o nome e alterar para novo nome.
					this.listaCliente.get(i).setDataNasc(cliente.getDataNasc()); // Percorre a lista para achar a data e alterar.
					this.listaCliente.get(i).setRg(cliente.getRg()); // Percorre a lista para achar o rg e alterar.
					this.listaCliente.get(i).setEmail(cliente.getEmail()); // Percorre a lista para achar o email e alterar.
					this.listaCliente.get(i).setTelefone(cliente.getTelefone()); // Percorre a lista para achar o telefone e alterar.
					this.listaCliente.get(i).setSalario(cliente.getSalario()); // Percorre a lista para achar o salario e alterar.
					return ResponseEntity.ok("Dados Atualizados"); // Retorna um recurso 200 com a frase escrita.
				}	
			}
		}	
		return ResponseEntity.notFound().build(); // Retorna um recurso não encontrado, deixando a página em branco, e não aparecendo um erro. 
	}
	
	@DeleteMapping("/{cpf}") // Deleta o cliente que tiver o cpf inserido. É atalho do @RequestMapping.
	public ResponseEntity<String> deletar(@PathVariable("cpf") String cpf) { // // Declara o metodo como publico, Usa uma resposta String e mapeia o CPF no parametro.
		if(this.listaCliente != null) { // Verifica se não é nulo.
			for(int i=0;i<listaCliente.size();i++) { // Faz um loop pela lista de clientes, mapeando para a proxima linha executar.
				if(this.listaCliente.get(i).getCpf().equalsIgnoreCase(cpf)) { // Verifica se o cpf inserido é valido.
					this.listaCliente.remove(i); // Remove o cliente que teve o cpf inserido.
					return ResponseEntity.ok("Cliente removido"); // Retorna um recurso 200 com a frase escrita.
				}
			}
		}
		return ResponseEntity.notFound().build(); // Retorna um recurso não encontrado, deixando a página em branco, e não aparecendo um erro. 
		
	}
	
	
	

}
