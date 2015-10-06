package br.com.controlequipamentos.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Equipamento implements Serializable {
	private static final long serialVersionUID = -9163826571643132969L;
	private int id;
	private String nome;
	private Date dataCompra;
	private Date dataCadastro;
	private Date dataInicioOperacao;
	private String marca;
	private int idCategoria;
	private int idSetor;
	private int idFuncionario;
	private int idRequisito;
	
	public Equipamento(){
		
	}
	public Equipamento(String nome, Date dataCompra, Date dataCadastro, Date dataInicioOperacao, String marca, int idCategoria, int idSetor, int idFuncionario, int idRequisito) {
		super();
		this.nome = nome;
		this.dataCompra = dataCompra;
		this.dataCadastro = dataCadastro;
		this.dataInicioOperacao = dataInicioOperacao;
		this.marca = marca;
		this.idCategoria = idCategoria;
		this.idSetor = idSetor;
		this.idFuncionario = idFuncionario;
		this.idRequisito = idRequisito;
	}
	
	public Equipamento(int id, String nome, Date dataCompra, Date dataCadastro, Date dataInicioOperacao, String marca, int idCategoria, int idSetor, int idFuncionario, int idRequisito) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCompra = dataCompra;
		this.dataCadastro = dataCadastro;
		this.dataInicioOperacao = dataInicioOperacao;
		this.marca = marca;
		this.idCategoria = idCategoria;
		this.idSetor = idSetor;
		this.idFuncionario = idFuncionario;
		this.idRequisito = idRequisito;
	}
	
	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", nome=" + nome + ", dataCompra=" + dataCompra + ", dataCadastro="
				+ dataCadastro + ", dataInicioOperacao=" + dataInicioOperacao + ", marca=" + marca + ", idCategoria="
				+ idCategoria + ", idSetor=" + idSetor + ", idFuncionario=" + idFuncionario + ", idRequisito="
				+ idRequisito + "]";
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
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataInicioOperacao() {
		return dataInicioOperacao;
	}
	public void setDataInicioOperacao(Date dataInicioOperacao) {
		this.dataInicioOperacao = dataInicioOperacao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
	public int getIdRequisito() {
		return idRequisito;
	}
	public void setIdRequisito(int idRequisito) {
		this.idRequisito = idRequisito;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
