package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Equipamento implements Serializable {

	private static final long serialVersionUID = -9163826571643132969L;
	private String id;
	private String nome;
	private String modelo;
	private String dataInicio;
	private String dataFim;
	private String servstag;
	private String patrimonio;
	private String idCategoria;
	private String idMarca;
	private String idSetor;
	private String idFuncionario;
	private String idRequisito;
	private String idEstado;

	public Equipamento() {

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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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

	public String getServstag() {
		return servstag;
	}

	public void setServstag(String servstag) {
		this.servstag = servstag;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}

	public String getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(String idRequisito) {
		this.idRequisito = idRequisito;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}



}
