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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "id")
	private int id;
	@Column(name = "datacompra")
	@Temporal(TemporalType.DATE)
	private Date datacompra;
	@Column(name = "dataentrega")
	@Temporal(TemporalType.DATE)
	private Date dataentrega;
	@Column(name = "valorproduto")
	private float valorproduto;
	@Column(name = "valorimposto")
	private float valorimposto;
	@Column(name = "valortotal")
	private float valortotal;
	@OneToMany
	@JoinColumn(name = "cliente", referencedColumnName= "id")
	private Cliente cliente;
	@JoinColumn(name = "compraItens", referencedColumnName= "id")
	@OneToMany
	private CompraItens compraItens;
	
	// Construtor
		//public Compra() {
			//this.compraItens = new ArrayList<CompraItens>();
		//}
	
	// Get e Set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatacompra() {
		return datacompra;
	}
	public void setDatacompra(Date datacompra) {
		this.datacompra = datacompra;
	}
	public Date getDataentrega() {
		return dataentrega;
	}
	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}
	public float getValorproduto() {
		return valorproduto;
	}
	public void setValorproduto(float valorproduto) {
		this.valorproduto = valorproduto;
	}
	public float getValorimposto() {
		return valorimposto;
	}
	public void setValorimposto(float valorimposto) {
		this.valorimposto = valorimposto;
	}
	public float getValortotal() {
		return valortotal;
	}
	public void setValortotal(float valortotal) {
		this.valortotal = valortotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public String toString() {
		return "Compra [id=" + id + ", datacompra=" + datacompra + ", dataentrega=" + dataentrega + ", valorproduto="
				+ valorproduto + ", valorimposto=" + valorimposto + ", valortotal=" + valortotal + ", cliente="
				+ cliente + ", compraItens=" + compraItens + "]";
	}
	
}
