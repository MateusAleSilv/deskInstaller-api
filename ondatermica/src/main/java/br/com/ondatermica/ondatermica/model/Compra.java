package br.com.ondatermica.ondatermica.model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private Integer numeroCompra;
	private String dataCompra;
	private String dataEntrega;
	private float valorProduto;
	private float valorImposto;
	private float valorTotal;
	private Cliente cliente;
	private List<Itens> listaItens;
	
	public Compra() {
		this.listaItens = new ArrayList<Itens>();
	}
	
	
	//Get e Set
	public Integer getNumeroCompra() {
		return numeroCompra;
	}
	public void setNumeroCompra(Integer numeroCompra) {
		this.numeroCompra = numeroCompra;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(float valorProdutos) {
		this.valorProduto = valorProdutos;
	}
	public float getValorImposto() {
		return valorImposto;
	}
	public void setValorImposto(float valorImpostor) {
		this.valorImposto = valorImpostor;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	//-------------------------------------------------
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Itens> getListaItens() {
		return listaItens;
	}
	public void setListaItens(List<Itens> listaItens) {
		this.listaItens = listaItens;
	}
	
	
	
}
