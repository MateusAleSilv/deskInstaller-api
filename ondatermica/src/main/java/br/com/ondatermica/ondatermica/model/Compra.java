package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "compra")
public class Compra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "numerocompra")
	private Integer numeroCompra;
	@Column(name = "dataCompra")
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	@Column(name = "dataEntrega")
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	@Column(name = "valorProduto")
	private float valorProduto;
	@Column(name = "valorImposto")
	private float valorImposto;
	@Column(name = "valorTotal")
	private float valorTotal;
	
	
	@JoinColumn(name = "cliente", referencedColumnName= "idcliente")
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Itens> listaItens;
	
	
	//Construtor
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
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
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


	@Override
	public String toString() {
		return "Compra [numeroCompra=" + numeroCompra + ", dataCompra=" + dataCompra + ", dataEntrega=" + dataEntrega
				+ ", valorProduto=" + valorProduto + ", valorImposto=" + valorImposto + ", valorTotal=" + valorTotal
				+ ", cliente=" + cliente + ", listaItens=" + listaItens + "]";
	}
	
	
	
}
