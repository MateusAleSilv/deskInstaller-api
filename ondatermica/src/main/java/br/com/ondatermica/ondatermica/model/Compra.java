package br.com.ondatermica.ondatermica.model;

public class Compra {

	private String numeroCompra;
	private String dataCompra;
	private String dataEntrega;
	private float valorProduto;
	private float valorImposto;
	private float valorTotal;
	
	//Get e Set
	public String getNumeroCompra() {
		return numeroCompra;
	}
	public void setNumeroCompra(String numeroCompra) {
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
	
	
}
