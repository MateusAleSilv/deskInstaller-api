package br.com.ondatermica.ondatermica.model;

public class Itens {
	
	private int numero;
	private int quantidade;
	private float valor;
	private float valorImposto;
	private Produtos produtos;
	
	
	// Get e Set
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getValorImposto() {
		return valorImposto;
	}
	public void setValorImposto(float valorImposto) {
		this.valorImposto = valorImposto;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
