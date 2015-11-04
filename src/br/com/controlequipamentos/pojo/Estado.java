package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Estado implements Serializable{

	private static final long serialVersionUID = 6772826252846338346L;
	private String id;
	private String nome;
	
	public Estado() {
	
	}
	
	public Estado(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
