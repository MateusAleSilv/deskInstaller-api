package br.com.ondatermica.ondatermica.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "idcliente")
	private int idCliente;
	@Column(name = "nome")
	private String nome;
	@Column(name = "dataNasc")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "rg")
	private String rg;
	@Column(name = "email")
	private String email;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "salario")
	private float salario;
	

	//Contrutor
	public Cliente() {
		super();
	}

	//Get e Set
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", dataNasc=" + dataNasc + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email
				+ ", telefone=" + telefone + ", salario=" + salario + "]";
	}

	
	
	
	
}
