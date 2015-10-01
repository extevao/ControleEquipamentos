package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 913854533111421693L;
	private int id;
	private String login;
	private String senha;
	private int idFuncionario;

	public Usuario(){
		
	}
	public Usuario(int id, String login, String senha, int idFuncionario) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.idFuncionario = idFuncionario;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", idFuncionario=" + idFuncionario + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	




}
