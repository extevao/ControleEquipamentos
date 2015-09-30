package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 913854533111421693L;
	private int id;
	private String nome;
	private String sobrenome;
	private String email;

	public Usuario() {

	}

	public Usuario(int id, String nome, String sobreNome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobreNome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobrenome + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobreNome) {
		this.sobrenome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




}
