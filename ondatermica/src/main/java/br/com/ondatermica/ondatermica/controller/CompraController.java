package br.com.ondatermica.ondatermica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ondatermica.ondatermica.model.Compra;
import br.com.ondatermica.ondatermica.model.Itens;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/compras")
@Api("API REST Produtos")
@CrossOrigin(origins="*")
public class CompraController {

	private List<Compra> listaCompras;
	
	
	@GetMapping
	@ApiOperation(value="Retorna todo lista de compras.")
	public ResponseEntity<List<Compra>> listarCompras() {
		if(this.listaCompras != null) {
			return ResponseEntity.ok(listaCompras);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/numero/{numeroCompra}")
	@ApiOperation(value="Retorna uma lista unica.")
	public ResponseEntity<Compra> numeroCompra(@PathVariable("numeroCompra") Integer numeroCompra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getNumeroCompra() == numeroCompra) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/entrega/{dataEntrega}")
	@ApiOperation(value="Retorna uma lista pela data de entrega.")
	public ResponseEntity<Compra> dataEntrega(@PathVariable("dataEntrega") String dataEntrega) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getDataEntrega().equals(dataEntrega)) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/data/{dataCompra}")
	@ApiOperation(value="Retorna uma lista pela data de compra.")
	public ResponseEntity<Compra> dataCompra(@PathVariable("dataCompra") String dataCompra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getDataCompra().equals(dataCompra)) {
					return ResponseEntity.ok(this.listaCompras.get(i));
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cliente/{cpf}")
	@ApiOperation(value="Retorna uma lista buscando pelo cpf do cliente.")
	public ResponseEntity<List<Compra>> consultaCompras(@PathVariable("cpf") String cpf){
		 List<Compra> listaComprasCliente = new ArrayList<Compra>();
		 if(this.listaCompras != null) {
			 for(int i=0;i<listaCompras.size();i++) {
				 if(this.listaCompras.get(i).getCliente().getCpf().equalsIgnoreCase(cpf)) {
					 listaComprasCliente.add(listaCompras.get(i));
				 }
			 }
		 }
		 return ResponseEntity.ok(listaComprasCliente);
		 
	}
	
	
	// ---------------------------------------------------------------------------------------------------------
	
	@PostMapping
	@ApiOperation(value="Salva dados da compra.")
	public ResponseEntity<String> salvar(@RequestBody Compra compra) {
		if(this.listaCompras == null) {
			this.listaCompras = new ArrayList<Compra>();
		}
		this.listaCompras.add(compra);
		return ResponseEntity.ok("Dados Inseridos");
	}
	
	@PostMapping("numero/{numero}")
	@ApiOperation(value="Salva e calcula itens e produtos à compra.")
	public ResponseEntity<String> adicionar(@PathVariable("numero") Integer numero, @RequestBody Itens item ){
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getNumeroCompra() == numero) {
					
					item.setItemValor(calcularValorDoItem(item.getItemQuantidade(), item.getProdutos().getValor()));
					
					this.listaCompras.get(i).getListaItens().add(item);
					
					this.listaCompras.get(i).setValorProduto(this.listaCompras.get(i).getValorProduto() + item.getItemValor());
					
					//item.setValorImposto(calcularImposto(item.getProdutos().getValor(), item.getProdutos().getIcms()));
					
					this.listaCompras.get(i).setValorImposto(calcularImposto(item.getProdutos().getValor(), item.getProdutos().getIcms()));
					
					this.listaCompras.get(i).setValorTotal(calcularTotal(this.listaCompras.get(i).getValorImposto(), this.listaCompras.get(i).getValorProduto()));
					
					return ResponseEntity.ok("Item Incluido");
				}
			}
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping
	@ApiOperation(value="Atualiza a compra.")
	public ResponseEntity<String> atualizar(@RequestBody Compra compra) {
		if(this.listaCompras != null) {
			for(int i=0;i<listaCompras.size();i++) {
				if(this.listaCompras.get(i).getNumeroCompra() == compra.getNumeroCompra()) {
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
	@ApiOperation(value="Deleta todos dados da compra buscado pelo numero da mesma.")
	public ResponseEntity<String> deletar(@PathVariable("numeroCompra") Integer numeroCompra) {
		if(this.listaCompras != null) { 
			for(int i=0;i<listaCompras.size();i++) { 
				if(this.listaCompras.get(i).getNumeroCompra() == numeroCompra) { 
					this.listaCompras.remove(i); 
					return ResponseEntity.ok("Cliente removido");
				}
			}
		}
		return ResponseEntity.notFound().build();
		
	}
	
	public Float calcularValorDoItem(double quantidade, Float valor) {
		return  (float) (quantidade * valor);
	}
	
	public Float calcularImposto(Float valor, Double icms) {
		return (float) (valor + (icms/100));
	}
	
	public Float calcularTotal(Float valorImposto, Float valorProduto) {
		return (valorImposto + valorProduto);
	}
	

}
