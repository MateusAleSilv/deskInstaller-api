package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Itens")
public class Itens implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "iditens")
	private int idItens;
	@Column(name = "itemnumero")
	private int itemNumero;
	@Column(name = "itemquantidade")
	private int itemQuantidade;
	@Column(name = "itemvalor")
	private float itemValor;
	@Column(name = "valorImposto")
	private float valorImposto;
	
	
	@JoinColumn(name = "produto", referencedColumnName= "codigo")
	@ManyToOne
	private Produtos produtos;
	
	
	
	// Get e Set
	public int getIdItens() {
		return idItens;
	}
	public void setIdItens(int idItens) {
		this.idItens = idItens;
	}
	public int getItemNumero() {
		return itemNumero;
	}
	public void setItemNumero(int itemNumero) {
		this.itemNumero = itemNumero;
	}
	public int getItemQuantidade() {
		return itemQuantidade;
	}
	public void setItemQuantidade(int itemQuantidade) {
		this.itemQuantidade = itemQuantidade;
	}
	public float getItemValor() {
		return itemValor;
	}
	public void setItemValor(float itemValor) {
		this.itemValor = itemValor;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Itens [numero=" + itemNumero + ", quantidade=" + itemQuantidade + ", valor=" + itemValor + ", valorImposto="
				+ valorImposto + ", produtos=" + produtos + "]";
	}
	
}
