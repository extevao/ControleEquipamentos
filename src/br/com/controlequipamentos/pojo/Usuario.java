package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 913854533111421693L;
	private int id;
	private String nome;
	private String sobreNome;
	private String email;

	public Usuario() {

	}

	public Usuario(int id, String nome, String sobreNome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + "]";
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


	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




}
