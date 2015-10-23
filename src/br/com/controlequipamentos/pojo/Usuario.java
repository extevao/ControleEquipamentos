package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 913854533111421693L;
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private int idStatus;
	private int idSetor;

	public Usuario(){
		
	}
	
	

	public Usuario(int id, String nome, String sobrenome, String email, String login, String senha, int idStatus,
			int idSetor) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.login = login;
		this.senha = senha;
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
