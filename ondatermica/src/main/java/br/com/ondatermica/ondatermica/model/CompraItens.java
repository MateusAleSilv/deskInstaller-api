package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compraItens")
public class CompraItens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "id")
	private int id;
	@OneToOne
	@JoinColumn(name = "compra", referencedColumnName= "id")
	private Compra compra;
	@ManyToOne
	@JoinColumn(name= "itens", referencedColumnName= "id")
	private List<Itens> listaItens;
	
	// Construtor
		public CompraItens() {
		this.listaItens = new ArrayList<Itens>();
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public List<Itens> getListaItens() {
		return listaItens;
	}
	public void setListaItens(List<Itens> listaItens) {
		this.listaItens = listaItens;
	}

	@Override
	public String toString() {
		return "CompraItens [id=" + id + ", compra=" + compra + ", listaItens=" + listaItens + "]";
	}
		
	
	
	
}
