package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Setor implements Serializable {

	private static final long serialVersionUID = -5581268418367797182L;
	private int id;
	private String nome;
	private int idStatus;
	private int idRequisito;
	
	public Setor(){
		
	}

	public Setor(int id, String nome, int idStatus, int idRequisito) {

		this.id = id;
		this.nome = nome;
		this.idStatus = idStatus;
		this.idRequisito = idRequisito;
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

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(int idRequisito) {
		this.idRequisito = idRequisito;
	}

	
}
