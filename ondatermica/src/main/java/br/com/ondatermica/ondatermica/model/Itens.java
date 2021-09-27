package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "itens")
public class Itens implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "id")
	private int id;
	@Column(name = "itemnumero")
	private int itemnumero;
	@Column(name = "itemquantidade")
	private int itemquantidade;
	@Column(name = "itemvalor")
	private float itemvalor;
	@Column(name = "valorimposto")
	private float valorimposto;
	@ManyToOne
	@JoinColumn(name = "produtos", referencedColumnName= "id")
	private Produtos produtos;
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemnumero() {
		return itemnumero;
	}
	public void setItemnumero(int itemnumero) {
		this.itemnumero = itemnumero;
	}
	public int getItemquantidade() {
		return itemquantidade;
	}
	public void setItemquantidade(int itemquantidade) {
		this.itemquantidade = itemquantidade;
	}
	public float getItemvalor() {
		return itemvalor;
	}
	public void setItemvalor(float itemvalor) {
		this.itemvalor = itemvalor;
	}
	public float getValorimposto() {
		return valorimposto;
	}
	public void setValorimposto(float valorimposto) {
		this.valorimposto = valorimposto;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	@Override
	public String toString() {
		return "Itens [id=" + id + ", itemnumero=" + itemnumero + ", itemquantidade=" + itemquantidade
				+ ", itemvalor=" + itemvalor + ", valorimposto=" + valorimposto + ", produtos=" + produtos + "]";
	}
}
