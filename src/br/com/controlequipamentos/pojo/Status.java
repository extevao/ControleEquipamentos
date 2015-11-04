package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Status implements Serializable{

	private static final long serialVersionUID = -2244044344629535444L;
	private String id;
	private String nome;
	
	
	public Status() {
	
	}

	public Status(String id, String nome) {
		super();
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
