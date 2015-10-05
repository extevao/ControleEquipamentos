package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class UsuarioTeste implements Serializable{

	private static final long serialVersionUID = -5787245029936399488L;
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	
	public UsuarioTeste(){
		
	}
	public UsuarioTeste(int id, String nome, String sobrenome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	public UsuarioTeste(String nome, String sobrenome, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
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
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
