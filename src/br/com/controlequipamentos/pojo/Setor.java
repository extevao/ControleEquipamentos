package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Setor implements Serializable {

	private static final long serialVersionUID = -5581268418367797182L;
	private int id;
	private String nome;
	private int idRequisito;
	private int idEquipamento;
	
	public Setor(){
		
	}
	public Setor(int id, String nome, int idRequisito, int idEquipamento) {
		this.id = id;
		this.nome = nome;
		this.idRequisito = idRequisito;
		this.idEquipamento = idEquipamento;
	}
	
	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", idRequisito=" + idRequisito + ", idEquipamento="
				+ idEquipamento + "]";
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
	public int getIdRequisito() {
		return idRequisito;
	}
	public void setIdRequisito(int idRequisito) {
		this.idRequisito = idRequisito;
	}
	public int getIdEquipamento() {
		return idEquipamento;
	}
	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
	

	
	
}
