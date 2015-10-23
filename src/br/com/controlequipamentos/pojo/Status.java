package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Status implements Serializable{

	private static final long serialVersionUID = -2244044344629535444L;
	private int id;
	private String nome;
	
	
	public Status() {
	
	}

	public Status(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	
	
}
