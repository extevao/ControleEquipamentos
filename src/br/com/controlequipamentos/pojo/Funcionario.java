package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2709836540260025787L;
	private int id;
	private String nome;
	private String sobreNome;
	private String email;
	private String cargo;
	private int idSetor;
	
	public Funcionario(){
		
	}
	
	public Funcionario(int id, String nome, String sobreNome, String email, String cargo, int idSetor) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cargo = cargo;
		this.idSetor = idSetor;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", cargo="
				+ cargo + ", idSetor=" + idSetor + "]";
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
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
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
	public int getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}

}
