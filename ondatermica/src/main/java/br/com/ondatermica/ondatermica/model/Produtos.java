package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private int id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "unidade")
	private int unidade;
	@Column(name = "produtosvalor")
	private float produtosvalor;
	@Column(name = "icms")
	private double icms;

	
	public Produtos() {
		super();
	}
	
	
	// Get e Set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	public float getProdutosvalor() {
		return produtosvalor;
	}
	public void setProdutosvalor(float produtosvalor) {
		this.produtosvalor = produtosvalor;
	}
	public double getIcms() {
		return icms;
	}
	public void setIcms(double icms) {
		this.icms = icms;
	}
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", descricao=" + descricao + ", unidade=" + unidade + ", produtosvalor="
				+ produtosvalor + ", icms=" + icms + "]";
	}
	


}
