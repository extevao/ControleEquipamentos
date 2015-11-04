package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Categoria implements Serializable{
	private static final long serialVersionUID = 1517556809245587L;
	
	private String id;
	private String nome;
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

	public Categoria(){
		
	}
	
	public Categoria(String id, String nome) {
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
