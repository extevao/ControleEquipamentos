package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 913854533111421693L;
	private String id;
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private String idStatus;
	private String idSetor;

	public Usuario(){
		
	}
	
	

	public Usuario(String id, String nome, String sobrenome, String email, String login, String senha, String idStatus,
			String idSetor) {
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

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	public String getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	


}
