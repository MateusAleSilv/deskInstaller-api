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

import br.com.ondatermica.ondatermica.model.Produtos;
import br.com.ondatermica.ondatermica.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;

	// --------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<Optional<List<Produtos>>> descricao(@PathVariable("descricao") String descricao ) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		 return ResponseEntity.ok(produtosRepository.findByDescricaoContainingOrderByDescricao(descricao));	
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Produtos>> codigo(@PathVariable("id") int id){
	 return ResponseEntity.ok(produtosRepository.findById(id));
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Produtos salvar(@Validated @RequestBody Produtos produtos) {
		return produtosRepository.save(produtos);
	}
	
	
	
	
	
	
}
