package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Manutencao implements Serializable {

	private static final long serialVersionUID = -4985405848018743735L;

	private int id;
	private String titulo;
	private String descricao;
	private String dataInicio;
	private String dataFim;
	private int idEquipamento;
	private int idSetor;
	private int idFuncionario;
	private int idUsuario;
	private int idEstado;
	
	public Manutencao(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public int getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	

	
}
