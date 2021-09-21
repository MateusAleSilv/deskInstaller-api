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
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "unidade")
	private int unidade;
	@Column(name = "produtovalor")
	private float produtoValor;
	@Column(name = "icms")
	private double icms;
	
	
	
	// Get e Set
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public float getValor() {
		return produtoValor;
	}
	public void setValor(float valor) {
		this.produtoValor = valor;
	}
	public double getIcms() {
		return icms;
	}
	public void setIcms(double icms) {
		this.icms = icms;
	}
	
	
	@Override
	public String toString() {
		return "Produtos [codigo=" + codigo + ", descricao=" + descricao + ", unidade=" + unidade + ", valor=" + produtoValor
				+ ", icms=" + icms + "]";
	}
	
	
	
}
