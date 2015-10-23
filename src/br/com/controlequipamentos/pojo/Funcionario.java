package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 2709836540260025787L;
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String cargo;
	private int idStatus;
	private int idSetor;

	public Funcionario() {

	}

	public Funcionario(int id, String nome, String sobrenome, String email, String cargo, int idStatus, int idSetor) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cargo = cargo;
		this.idStatus = idStatus;
		this.idSetor = idSetor;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}

}
