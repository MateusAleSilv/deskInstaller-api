package br.com.ondatermica.ondatermica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ondatermica.ondatermica.model.Compra;


@RestController
@RequestMapping("/compras")
public class CompraController {

	private List<Compra> listaCompras;
	
	
	@GetMapping
	public ResponseEntity<List<Compra>> listarCompras() {
		if(this.listaCompras != null) {
			return ResponseEntity.ok(listaCompras);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/numero/{numeroCompra}")
	public ResponseEntity<Compra> numeroCompra(@PathVariable("numeroCompra") String numeroCompra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getNumeroCompra().equalsIgnoreCase(numeroCompra)) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/entrega/{dataEntrega}")
	public ResponseEntity<Compra> dataEntrega(@PathVariable("dataEntrega") String dataEntrega) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getDataEntrega().equalsIgnoreCase(dataEntrega)) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/data/{dataCompra}")
	public ResponseEntity<Compra> dataCompra(@PathVariable("dataCompra") String dataCompra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getDataCompra().equalsIgnoreCase(dataCompra)) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	// ---------------------------------------------------------------------------------------------------------
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody Compra compra) {
		if(this.listaCompras == null) {
			this.listaCompras = new ArrayList<Compra>();
		}
		this.listaCompras.add(compra);
		return ResponseEntity.ok("Dados Inseridos");
	}
	
	@PutMapping
	public ResponseEntity<String> atualizar(@RequestBody Compra compra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getNumeroCompra().equalsIgnoreCase(compra.getNumeroCompra())) {
					this.listaCompras.get(i).setDataCompra(compra.getDataCompra());
					this.listaCompras.get(i).setDataEntrega(compra.getDataEntrega());
					this.listaCompras.get(i).setValorProduto(compra.getValorProduto());
					this.listaCompras.get(i).setValorImposto(compra.getValorImposto());
					this.listaCompras.get(i).setValorTotal(compra.getValorTotal());
					return ResponseEntity.ok("Dados Atualizados");
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{numeroCompra}")
	public ResponseEntity<String> deletar(@PathVariable("numeroCompra") String numeroCompra) {
		if(this.listaCompras != null) { 
			for(int i=0;i<listaCompras.size();i++) { 
				if(this.listaCompras.get(i).getNumeroCompra().equalsIgnoreCase(numeroCompra)) { 
					this.listaCompras.remove(i); 
					return ResponseEntity.ok("Cliente removido");
				}
			}
		}
		return ResponseEntity.notFound().build();
		
	}
}
