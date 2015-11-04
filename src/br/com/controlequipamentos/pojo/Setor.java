package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Setor implements Serializable {

	private static final long serialVersionUID = -5581268418367797182L;
	private String id;
	private String nome;
	private String idStatus;
	private String idRequisito;
	
	public Setor(){
		
	}

	public Setor(String id, String nome, String idStatus, String idRequisito) {

		this.id = id;
		this.nome = nome;
		this.idStatus = idStatus;
		this.idRequisito = idRequisito;
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

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	public String getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(String idRequisito) {
		this.idRequisito = idRequisito;
	}

	
}
