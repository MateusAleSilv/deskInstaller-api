package br.com.ondatermica.ondatermica.model;

public class Cliente {

	private Object nome = null;
	private Object dataNasc = null;
	private Object cpf = null;
	private Object rg = null;
	private Object email = null;
	private Object telefone = null;

	// Get e Set
	public Object getNome() {
		return this.nome;
	}

	public void setNome(Object nome) {
		this.nome = nome;
	}

	public Object getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Object dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Object getCpf() {
		return cpf;
	}

	public void setCpf(Object cpf) {
		this.cpf = cpf;
	}

	public Object getRg() {
		return rg;
	}

	public void setRg(Object rg) {
		this.rg = rg;
	}

	public Object getEmail() {
		return email;
	}

	public void setEmail(Object email) {
		this.email = email;
	}

	public Object getTelefone() {
		return telefone;
	}

	public void setTelefone(Object telefone) {
		this.telefone = telefone;
	}
	
	
	
}
