package br.com.controlequipamentos.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Manutencao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4985405848018743735L;

	private int id;
	private String descricao;
	private String motivo;
	private Date dataInicio;
	private Date dataFim;
	private int idEquipamento;
	private int idSetor;
	private int idFuncionario;
	private int idUsuario;
	
	public Manutencao(){
		
	}
	
	public Manutencao(int id, String descricao, String motivo, Date dataInicio, Date dataFim, int idEquipamento,
			int idSetor, int idFuncionario, int idUsuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.motivo = motivo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.idEquipamento = idEquipamento;
		this.idSetor = idSetor;
		this.idFuncionario = idFuncionario;
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Manutencao [id=" + id + ", descricao=" + descricao + ", motivo=" + motivo + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", idEquipamento=" + idEquipamento + ", idSetor=" + idSetor
				+ ", idFuncionario=" + idFuncionario + ", idUsuario=" + idUsuario + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
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
	
	

	
}
