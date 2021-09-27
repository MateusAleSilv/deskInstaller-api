package br.com.ondatermica.ondatermica.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ondatermica.ondatermica.model.Compra;
import br.com.ondatermica.ondatermica.repository.CompraRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/compra")
@Api("API REST Compra")
@CrossOrigin(origins="*")
public class CompraController {

	
	@Autowired 
	private CompraRepository compraRepository;
	
	// ------------------------------------------------------------------------------------------------------
	
	@GetMapping("/id/{id}")
	@ApiOperation(value= "Retorna a lista de compras pelo id")
	public ResponseEntity<Optional<Compra>> idCompra(@PathVariable("id") int id){
		return ResponseEntity.ok(compraRepository.findById(id));
	}
	
	@GetMapping("/data/{datacompra}")
	@ApiOperation(value= "Retorna a lista de compras pela data de compra")
	public ResponseEntity<Optional<List<Compra>>> dataCompra(@PathVariable("datacompra") Date datacompra){
		 return ResponseEntity.ok(compraRepository.findByDatacompraContainingOrderByDatacompra(datacompra));	
	}

	
	// ---------------------------------------------------------------------------------------------------------
	
	@PostMapping("/salvar")
	@ApiOperation(value= "Salva a lista de compra")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra salvar(@Validated @RequestBody Compra compra) {
		return compraRepository.save(compra);
	}
	
}
